/*
    INDRA/CAR/mmg
    $Id: CobGrupoUsuarCobraLPStartUp.java,v 1.1 2009/12/03 18:41:08 pecbazalar Exp $
    DESC
*/
import java.util.*;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;

import es.indra.utils.*;
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.belcorp.MMGNoLanguageException;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import java.text.DecimalFormatSymbols;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CobGrupoUsuarCobraLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios seg�n el modo
	public static final short QUERYFORM_SIZE = 189;
	public static final short CREATEFORM_SIZE = 427;
	public static final short UPDATEFORM_SIZE = 381;
	public static final short VIEWFORM_SIZE = 427;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCobGrupoUsuarCobraQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
				public static final String BUSINESSID_ESGROIDESTAGRUPUSUA_QUERY ="MMGCobEstadGrupoUsuarQueryFromToUser";
				public static final String ESGROIDESTAGRUPUSUA_COMBO_CONNECTOR = "CobEstadGrupoUsuarConectorCombo";
	
		
	//Hashtables con los valores est�ticos de radiobuttons y combos
	protected static Hashtable indUsuaExteValues = new Hashtable();
	static{
		indUsuaExteValues.put(new java.lang.Long(0), "No");
		indUsuaExteValues.put(new java.lang.Long(1), "Si");
	}
	
	
	// Definicion del constructor
	public CobGrupoUsuarCobraLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CobGrupoUsuarCobraPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuraci�n del mantenimiento
			super.ejecucion();
		
			this.getFormatosValidaciones();

			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tama�o de la p�gina
			buildJsPageSize("CobGrupoUsuarCobra");
			
			//Determinamos la acci�n y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el t�tulo i18nalizado
			//y para que funcione de forma correcta la configuraci�n del men� secundario
			asignarAtributo("PAGINA", "CobGrupoUsuarCobraPage", "cod", "CobGrupoUsuarCobra." + accion + ".label");
			
			//Ponemos en la p�gina el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tama�os y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Establecemos los valores por defecto de la entidades estructurales
			setDefaultStructuralValues();
			
			//Limpiamos la botonera
			limpiarBotoneraLista("cobGrupoUsuarCobra", accion);
			
			
			
			
			
			//Ejecutanos la acci�n solicitada		
			System.out.println("accion " + accion + " origen " + origen);
			if(accion.equals(ACCION_LOV)) cmdLov();
			else if(accion.equals(ACCION_QUERY)) cmdQuery();
			else if(accion.equals(ACCION_CREATE)) cmdCreate();
			else if(accion.equals(ACCION_REMOVE)) cmdRemove();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) cmdUpdate();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) cmdPreUpdateForm();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) cmdUpdateForm();
			else if(accion.equals(ACCION_VIEW) && origen.equals("pagina")) cmdPreView();
			else if(accion.equals(ACCION_VIEW) && origen.equals("preview")) cmdView();
			
			//Eliminamos los TRs del formulario que no tengan campos
			eliminarTrsVacios(accion, origen);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo lov*/
	protected void cmdLov() throws Exception{
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();
	
		//Cargamos las combos finales de las jerarqu�as de herencia
		loadLeafDependenceCombos(null);
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codGrupUsua", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "cobGrupoUsuarCobraLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CobGrupoUsuarCobraPage", "onblur", "window.focus();");
		
		//Borramos los elementos de internacionalizaci�n()
		removeLocalizationElements();
		removeNonSearchElements();
	}

	/**Acci�n previa para poder permitir la carga de datos en el formulario 
	de view con ventana oculta. Para ello simplemente redireccionamos al m�todo*/
	protected void cmdPreView() throws Exception{
		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos a la acci�n de view pasando la accion, y la acci�n anterior y actulizando el origen
		conectorAction("CobGrupoUsuarCobraLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view
	*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la b�squeda a partir del id que
		//lo sacamos de la request
		CobGrupoUsuarCobraData cobGrupoUsuarCobraQuery= new CobGrupoUsuarCobraData();
		cobGrupoUsuarCobraQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acci�n anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CobGrupoUsuarCobraData datosResult = (CobGrupoUsuarCobraData)getSingleObject(BUSINESSID_QUERY, cobGrupoUsuarCobraQuery, 
			cobGrupoUsuarCobraQuery.clone(), "cobGrupoUsuarCobra");
		
		
		//Comprobamos que haya datos. Si no indicamos la situaci�n
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		CobGrupoUsuarCobraData cobGrupoUsuarCobra = datosResult;
		asignar("TEXT", "codGrupUsua", FormatUtils.formatObject(cobGrupoUsuarCobra.getCodGrupUsua(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDesc", FormatUtils.formatObject(cobGrupoUsuarCobra.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "fecUltiEsta", FormatUtils.formatObject(cobGrupoUsuarCobra.getFecUltiEsta(), 
			 UtilidadesSession.getFormatoFecha(this), decimalFormatSymbols));
		if(cobGrupoUsuarCobra.getIndUsuaExte() != null){	
			checkCombo("indUsuaExte", FormatUtils.formatObject(cobGrupoUsuarCobra.getIndUsuaExte(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "valTurnHoraEntr", FormatUtils.formatObject(cobGrupoUsuarCobra.getValTurnHoraEntr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTurnHoraSali", FormatUtils.formatObject(cobGrupoUsuarCobra.getValTurnHoraSali(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valObse", FormatUtils.formatObject(cobGrupoUsuarCobra.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CobEstadGrupoUsuarData esgrOidEstaGrupUsua = cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua();
		if(esgrOidEstaGrupUsua != null && esgrOidEstaGrupUsua.getId() != null) checkCombo("esgrOidEstaGrupUsua" , esgrOidEstaGrupUsua.getId().toString());
		asignar("TEXT", "codUsua", FormatUtils.formatObject(cobGrupoUsuarCobra.getCodUsua(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codGrupUsua", "disabled", "S");
		asignarAtributo("TEXT", "valDesc", "disabled", "S");
		asignarAtributo("TEXT", "fecUltiEsta", "disabled", "S");
		
					asignarAtributo("COMBO", "indUsuaExte", "disabled", "S");asignarAtributo("TEXT", "valTurnHoraEntr", "disabled", "S");
		asignarAtributo("TEXT", "valTurnHoraSali", "disabled", "S");
		asignarAtributo("TEXT", "valObse", "disabled", "S");
		
					asignarAtributo("COMBO", "esgrOidEstaGrupUsua", "disabled", "S");asignarAtributo("TEXT", "codUsua", "disabled", "S");
		
		
	
		//Ponemos la pagina en modo view: Eliminamos el bot�n de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando s�lo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeNonViewElements();
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		

		//Cargamos las combos finales de las jerarqu�as de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codGrupUsua", "req", "S");
		asignarAtributo("TEXT", "valDesc", "req", "S");
		asignarAtributo("TEXT", "codUsua", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la funci�n de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codGrupUsua", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "fecUltiEsta", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		
		asignarAtributo("TEXT", "valTurnHoraEntr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 20);");
		asignarAtributo("TEXT", "valTurnHoraSali", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 20);");
		asignarAtributo("TEXT", "valObse", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 100);");
		
		asignarAtributo("TEXT", "codUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		//Ponemos la pagina en modo view: 
		//Eliminamos el bot�n de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando s�lo el campo simple
		removeLovElements();
		removeQueryElements();
		removeNonInsertElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo remove*/
	protected void cmdRemove() throws Exception{
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codGrupUsua", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de b�squeda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la p�gina
		//Cargamos las combos finales de las jerarqu�as de herencia
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}else loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion y lov
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	/**Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codGrupUsua", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de b�squeda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarqu�as de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la p�gina
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el bot�n lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalizaci�n para las etiquetas de los campos con b�squeda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codGrupUsua", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 10, 0, 9999999999);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de b�squeda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarqu�as de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la p�gina
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Simplemente elimnamos el bot�n lov de null selection y la internacionalizaci�n
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	
	/**Acci�n previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al m�todo*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("CobGrupoUsuarCobraLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Prepara el formulario para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acci�n anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "cobGrupoUsuarCobraFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "valDesc", "req", "S");
				asignarAtributo("TEXT", "codUsua", "req", "S");
		
		//Asignamos a los campos internacionalizables la funci�n de onblur para actualizar el valor
		//para el idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			asignarAtributo("TEXT", "fecUltiEsta", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
			
			asignarAtributo("TEXT", "valTurnHoraEntr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 20);");
			asignarAtributo("TEXT", "valTurnHoraSali", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 20);");
			asignarAtributo("TEXT", "valObse", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 100);");
			
			asignarAtributo("TEXT", "codUsua", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CobGrupoUsuarCobra");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la b�squeda
		CobGrupoUsuarCobraData cobGrupoUsuarCobraQuery= new CobGrupoUsuarCobraData();
		cobGrupoUsuarCobraQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		CobGrupoUsuarCobraData  datosResult = (CobGrupoUsuarCobraData)getSingleObject(BUSINESSID_QUERY, cobGrupoUsuarCobraQuery, 
			cobGrupoUsuarCobraQuery.clone(), "cobGrupoUsuarCobra");
		

		//Comprobamos que haya datos. Si no indicamos la situaci�pn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CobGrupoUsuarCobraData cobGrupoUsuarCobra = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "valDesc", FormatUtils.formatObject(cobGrupoUsuarCobra.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "fecUltiEsta", FormatUtils.formatObject(cobGrupoUsuarCobra.getFecUltiEsta(), 
			 UtilidadesSession.getFormatoFecha(this), decimalFormatSymbols));
		if(cobGrupoUsuarCobra.getIndUsuaExte() != null){	
			checkCombo("indUsuaExte", FormatUtils.formatObject(cobGrupoUsuarCobra.getIndUsuaExte(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "valTurnHoraEntr", FormatUtils.formatObject(cobGrupoUsuarCobra.getValTurnHoraEntr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTurnHoraSali", FormatUtils.formatObject(cobGrupoUsuarCobra.getValTurnHoraSali(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valObse", FormatUtils.formatObject(cobGrupoUsuarCobra.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CobEstadGrupoUsuarData esgrOidEstaGrupUsua = cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua();
		if(esgrOidEstaGrupUsua != null && esgrOidEstaGrupUsua.getId() != null) checkCombo("esgrOidEstaGrupUsua" , esgrOidEstaGrupUsua.getId().toString());
		asignar("TEXT", "codUsua", FormatUtils.formatObject(cobGrupoUsuarCobra.getCodUsua(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		

		//Sacamos la informaci�n de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la b�squeda
		//	Creamos el dto y metemos la informaci�n necesaria para ejecutar la query
		//	Invocamos la l�gica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acci�n
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se est� modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(cobGrupoUsuarCobra.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el bot�n de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando s�lo el campo simple
		//Borramos los elementos correspondientes a la internacionalizaci�n
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
		/** por eloy mier p�rez para agregar funcionalidad de desactivacion de campos */
		traza("MMG: antes de llamar a desactivateNonModifyFields .....");
		desactivateNonModifyFields();
		traza("MMG: despues de llamar a desactivateNonModifyFields ......");
		/** 
			por eloy mier p�rez para agregar funcionalidad de desactivacion de campos
			para reescribir funciones ontab y onshtab.
		 */
		cambiarAcciones();
	}

	/**
		Por EMP.
		Nos permite cambiar el evento ontab y onshtab de los objetos druida necesarios en el modo
		de modificaci�n.
	*/
	protected void cambiarAcciones() throws Exception{
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codGrupUsua", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codGrupUsua", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",2, false)");
				asignarAtributo("AREATEXTO", "valDesc", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",3, true)");
				asignarAtributo("AREATEXTO", "valDesc", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",3, false)");
				asignarAtributo("AREATEXTO", "fecUltiEsta", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",4, true)");
				asignarAtributo("AREATEXTO", "fecUltiEsta", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",4, false)");
				asignarAtributo("TEXT", "indUsuaExte", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",5, true)");
				asignarAtributo("TEXT", "indUsuaExte", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",5, false)");
				asignarAtributo("AREATEXTO", "valTurnHoraEntr", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",6, true)");
				asignarAtributo("AREATEXTO", "valTurnHoraEntr", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",6, false)");
				asignarAtributo("AREATEXTO", "valTurnHoraSali", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",7, true)");
				asignarAtributo("AREATEXTO", "valTurnHoraSali", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",7, false)");
				asignarAtributo("AREATEXTO", "valObse", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",8, true)");
				asignarAtributo("AREATEXTO", "valObse", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",8, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",9, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",9, false)");
					asignarAtributo("COMBO","esgrOidEstaGrupUsua", "ontab", "ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",10, true)");
					asignarAtributo("COMBO","esgrOidEstaGrupUsua", "onshtab", "ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",10, false)");
				asignarAtributo("AREATEXTO", "codUsua", "ontab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",11, true)");
				asignarAtributo("AREATEXTO", "codUsua", "onshtab","ejecutarAccionFocoModificacion(\"cobGrupoUsuarCobraFrm\",11, false)");
	}
	
	/**Nos permite eliminar de la p�gina todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","cobGrupoUsuarCobraTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la b�suqeda
		borrarNodo("TR","nombre","cobGrupoUsuarCobraTrButtons");

		//Borramos los elementos no necesarios de la b�squeda para los campos con b�squda
		//por intervalo
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de view
	*/
	protected void removeNonViewElements() throws Exception{
		
						borrarCampo("id");
							borrarCampo("paisOidPais");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserci�n
	*/
	protected void removeNonInsertElements() throws Exception{
		
						borrarCampo("id");
							borrarCampo("paisOidPais");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		borrarCampo("fecUltiEsta");
		borrarCampo("indUsuaExte");
		borrarCampo("valTurnHoraEntr");
		borrarCampo("valTurnHoraSali");
		borrarCampo("valObse");
		borrarCampo("paisOidPais");
		borrarCampo("codUsua");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificaci�n
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		borrarCampo("codGrupUsua");
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificaci�n
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es codGrupUsua...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codGrupUsua");
						asignarAtributo ("TEXT", "codGrupUsua", "disabled", "S");
				traza("MMG: el atributo es valDesc...");		
				
				traza("MMG: el atributo es fecUltiEsta...");		
				
				traza("MMG: el atributo es indUsuaExte...");		
				
				traza("MMG: el atributo es valTurnHoraEntr...");		
				
				traza("MMG: el atributo es valTurnHoraSali...");		
				
				traza("MMG: el atributo es valObse...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es esgrOidEstaGrupUsua...");		
				
				traza("MMG: el atributo es codUsua...");		
				
		}

	/**
	* Nos permite establecer el tama�o de las capas de la pantalla seg�n el modo
	* Esto se debe a que dependiendo del modo aparecen unos campos u otros 
	*/
	protected void establecerSizeCapas(String accion, String origen) throws Exception{
		//Dependiendo del modo el tama�o del formualrio ser� uno u otro
		int sizeForm = 0;
		if(accion.equals(ACCION_LOV)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_VIEW)) sizeForm = VIEWFORM_SIZE;
		else if(accion.equals(ACCION_CREATE)) sizeForm = CREATEFORM_SIZE;
		else if(accion.equals(ACCION_REMOVE)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_QUERY)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) sizeForm = UPDATEFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) sizeForm = UPDATEFORM_SIZE;
		
		//Establecemos el tama�o de la capa del formulario
		asignarAtributo("CAPA","cobGrupoUsuarCobraFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","cobGrupoUsuarCobraListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","cobGrupoUsuarCobraListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarqu�as de dependencia
	*/
	protected void loadLeafDependenceCombos(CobGrupoUsuarCobraData cobGrupoUsuarCobra) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(cobGrupoUsuarCobra != null && cobGrupoUsuarCobra.getPaisOidPais() != null){
				checkCombo("paisOidPais" , cobGrupoUsuarCobra.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		CobEstadGrupoUsuarData esgrOidEstaGrupUsua = new CobEstadGrupoUsuarData();
		
						asignarComboResultados(BUSINESSID_ESGROIDESTAGRUPUSUA_QUERY,ESGROIDESTAGRUPUSUA_COMBO_CONNECTOR, 
			esgrOidEstaGrupUsua, esgrOidEstaGrupUsua.clone(), "cobEstadGrupoUsuar", "esgrOidEstaGrupUsua", "result_ROWSET" );
		if(cobGrupoUsuarCobra != null && cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua() != null){
				checkCombo("esgrOidEstaGrupUsua" , cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarqu�a de combos dependientes por la selecci�n de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
	}
	
	/**
	* Este m�todo carga todos los combos de una jerarqu�a de dependencia. La carga se realiza c
	* se realiza en funci�n de los datos de un mso del mantenimiento. 
	* @param cobGrupoUsuarCobra La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CobGrupoUsuarCobraData cobGrupoUsuarCobra) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la �ltima query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la b�squeda
		CobGrupoUsuarCobraData cobGrupoUsuarCobra = 
			(CobGrupoUsuarCobraData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarqu�a de combos dependientes
		if(cobGrupoUsuarCobra.getPaisOidPais() != null){
			cobGrupoUsuarCobra.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			cobGrupoUsuarCobra.getPaisOidPais(),
			cobGrupoUsuarCobra.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua() != null){
			cobGrupoUsuarCobra.setEsgrOidEstaGrupUsua((es.indra.belcorp.mso.CobEstadGrupoUsuarData)
			getSingleObject(BUSINESSID_ESGROIDESTAGRUPUSUA_QUERY, 
			cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua(),
			cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua().clone(),
			"cobEstadGrupoUsuar"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarqu�as de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(cobGrupoUsuarCobra);
		loadLeafDependenceCombos(cobGrupoUsuarCobra);
	}
	
	/**
	*	Por defecto en los campos que tienen la b�squeda por intervalo el label del campo es el label
	*	correspondiente a campos normal (como si no fuera un campo con intervalor). En los modos de busqueda 
	*	(search, update search y remove search) tendremos que poner el label a la b�squeda "desde"
	*/
	protected void setIntervalSearchFromLavels() throws Exception{
	}
	
	/**
	*	Metodo que nos elimina los trs que quedan vac�os por no aparecer sus campos por el modo
	*/
	protected void eliminarTrsVacios(String accion, String origen) throws Exception{
		if(accion.equals(ACCION_QUERY) || accion.equals(ACCION_LOV) ||
			(accion.equals(ACCION_UPDATE) && origen.equals("menu")) ||
			(accion.equals(ACCION_REMOVE) && origen.equals("menu"))){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr3");
			borrarNodo("TR","nombre","formGapTr3");
			borrarNodo("TR","nombre","formTr4");
			borrarNodo("TR","nombre","formGapTr4");
			borrarNodo("TR","nombre","formTr5");
			borrarNodo("TR","nombre","formGapTr5");
			borrarNodo("TR","nombre","formTr6");
			borrarNodo("TR","nombre","formGapTr6");
			borrarNodo("TR","nombre","formTr7");
			borrarNodo("TR","nombre","formGapTr7");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr1");
			borrarNodo("TR","nombre","formGapTr1");
			
		}
	}
	
	
	
		
}





