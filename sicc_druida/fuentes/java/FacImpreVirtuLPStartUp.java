/*
    INDRA/CAR/mmg
    $Id: FacImpreVirtuLPStartUp.java,v 1.1 2009/12/03 18:33:42 pecbazalar Exp $
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
public class FacImpreVirtuLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 309;
	public static final short CREATEFORM_SIZE = 625;
	public static final short UPDATEFORM_SIZE = 625;
	public static final short VIEWFORM_SIZE = 625;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGFacImpreVirtuQueryFromToUserPage";
	
	
				public static final String BUSINESSID_TIIMOIDTIPO_QUERY ="MMGFacTipoImpreQueryFromToUser";
				public static final String TIIMOIDTIPO_COMBO_CONNECTOR = "FacTipoImpreConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	protected static Hashtable indEstaActiValues = new Hashtable();
	static{
		indEstaActiValues.put(new java.lang.Long(0), "Baja");
		indEstaActiValues.put(new java.lang.Long(1), "Activo");
	}
	protected static Hashtable numSecuValues = new Hashtable();
	static{
		numSecuValues.put(new java.lang.Long(0), "No");
		numSecuValues.put(new java.lang.Long(1), "Si");
	}
	
	
	// Definicion del constructor
	public FacImpreVirtuLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("FacImpreVirtuPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			this.getFormatosValidaciones();

			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("FacImpreVirtu");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "FacImpreVirtuPage", "cod", "FacImpreVirtu." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Establecemos los valores por defecto de la entidades estructurales
			setDefaultStructuralValues();
			
			//Limpiamos la botonera
			limpiarBotoneraLista("facImpreVirtu", accion);
			
			
			
			
			
			//Ejecutanos la acción solicitada		
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
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
	
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
		asignarAtributo("TEXT", "desImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		asignarAtributo("AREATEXTO", "valAtr1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "facImpreVirtuLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "FacImpreVirtuPage", "onblur", "window.focus();");
		
		//Borramos los elementos de internacionalización()
		removeLocalizationElements();
		removeNonSearchElements();
	}

	/**Acción previa para poder permitir la carga de datos en el formulario 
	de view con ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreView() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos a la acción de view pasando la accion, y la acción anterior y actulizando el origen
		conectorAction("FacImpreVirtuLPStartUp");
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
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		FacImpreVirtuData facImpreVirtuQuery= new FacImpreVirtuData();
		facImpreVirtuQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		FacImpreVirtuData datosResult = (FacImpreVirtuData)getSingleObject(BUSINESSID_QUERY, facImpreVirtuQuery, 
			facImpreVirtuQuery.clone(), "facImpreVirtu");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		FacImpreVirtuData facImpreVirtu = datosResult;
		asignar("TEXT", "codImpr", FormatUtils.formatObject(facImpreVirtu.getCodImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desImpr", FormatUtils.formatObject(facImpreVirtu.getDesImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.FacTipoImpreData tiimOidTipo = facImpreVirtu.getTiimOidTipo();
		if(tiimOidTipo != null && tiimOidTipo.getId() != null) checkCombo("tiimOidTipo" , tiimOidTipo.getId().toString());
		if(facImpreVirtu.getIndEstaActi() != null){	
			checkCombo("indEstaActi", FormatUtils.formatObject(facImpreVirtu.getIndEstaActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("AREATEXTO", "valAtr1", FormatUtils.formatObject(facImpreVirtu.getValAtr1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valAtr2", FormatUtils.formatObject(facImpreVirtu.getValAtr2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valAtr3", FormatUtils.formatObject(facImpreVirtu.getValAtr3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valAtr4", FormatUtils.formatObject(facImpreVirtu.getValAtr4(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTamaBuff", FormatUtils.formatObject(facImpreVirtu.getValTamaBuff(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(facImpreVirtu.getNumSecu() != null){	
			checkCombo("numSecu", FormatUtils.formatObject(facImpreVirtu.getNumSecu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codImpr", "disabled", "S");
		asignarAtributo("TEXT", "desImpr", "disabled", "S");
		
					asignarAtributo("COMBO", "tiimOidTipo", "disabled", "S");
					asignarAtributo("COMBO", "indEstaActi", "disabled", "S");asignarAtributo("AREATEXTO", "valAtr1", "disabled", "S");
		asignarAtributo("AREATEXTO", "valAtr2", "disabled", "S");
		asignarAtributo("AREATEXTO", "valAtr3", "disabled", "S");
		asignarAtributo("AREATEXTO", "valAtr4", "disabled", "S");
		asignarAtributo("TEXT", "valTamaBuff", "disabled", "S");
		
					asignarAtributo("COMBO", "numSecu", "disabled", "S");
		
	
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeNonViewElements();
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codImpr", "req", "S");
		asignarAtributo("TEXT", "desImpr", "req", "S");
		asignarAtributo("COMBO", "tiimOidTipo", "req", "S");
		asignarAtributo("COMBO", "indEstaActi", "req", "S");
		asignarAtributo("TEXT", "valTamaBuff", "req", "S");
		asignarAtributo("COMBO", "numSecu", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
		asignarAtributo("TEXT", "desImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		asignarAtributo("AREATEXTO", "valAtr1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		asignarAtributo("AREATEXTO", "valAtr2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		asignarAtributo("AREATEXTO", "valAtr3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		asignarAtributo("AREATEXTO", "valAtr4", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		asignarAtributo("TEXT", "valTamaBuff", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 12, 0, 999999999999);");
		
		
		
		//Ponemos la pagina en modo view: 
		//Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		removeLovElements();
		removeQueryElements();
		removeNonInsertElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo remove*/
	protected void cmdRemove() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
		asignarAtributo("TEXT", "desImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		asignarAtributo("AREATEXTO", "valAtr1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		//Cargamos las combos finales de las jerarquías de herencia
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
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
		asignarAtributo("TEXT", "desImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		asignarAtributo("AREATEXTO", "valAtr1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarquías de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el botón lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
		asignarAtributo("TEXT", "desImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
		
		
		asignarAtributo("AREATEXTO", "valAtr1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarquías de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Simplemente elimnamos el botón lov de null selection y la internacionalización
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	
	/**Acción previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("FacImpreVirtuLPStartUp");
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
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "facImpreVirtuFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codImpr", "req", "S");
				asignarAtributo("TEXT", "desImpr", "req", "S");
				asignarAtributo("COMBO", "tiimOidTipo", "req", "S");
				asignarAtributo("COMBO", "indEstaActi", "req", "S");
				asignarAtributo("TEXT", "valTamaBuff", "req", "S");
				asignarAtributo("COMBO", "numSecu", "req", "S");
		
		//Asignamos a los campos internacionalizables la función de onblur para actualizar el valor
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
		
			asignarAtributo("TEXT", "codImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 10);");
			asignarAtributo("TEXT", "desImpr", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
			
			
			asignarAtributo("AREATEXTO", "valAtr1", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
			asignarAtributo("AREATEXTO", "valAtr2", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
			asignarAtributo("AREATEXTO", "valAtr3", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
			asignarAtributo("AREATEXTO", "valAtr4", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 250)");
			asignarAtributo("TEXT", "valTamaBuff", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 12, 0, 999999999999);");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando FacImpreVirtu");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		FacImpreVirtuData facImpreVirtuQuery= new FacImpreVirtuData();
		facImpreVirtuQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		FacImpreVirtuData  datosResult = (FacImpreVirtuData)getSingleObject(BUSINESSID_QUERY, facImpreVirtuQuery, 
			facImpreVirtuQuery.clone(), "facImpreVirtu");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		FacImpreVirtuData facImpreVirtu = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codImpr", FormatUtils.formatObject(facImpreVirtu.getCodImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desImpr", FormatUtils.formatObject(facImpreVirtu.getDesImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.FacTipoImpreData tiimOidTipo = facImpreVirtu.getTiimOidTipo();
		if(tiimOidTipo != null && tiimOidTipo.getId() != null) checkCombo("tiimOidTipo" , tiimOidTipo.getId().toString());
		if(facImpreVirtu.getIndEstaActi() != null){	
			checkCombo("indEstaActi", FormatUtils.formatObject(facImpreVirtu.getIndEstaActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("AREATEXTO", "valAtr1", FormatUtils.formatObject(facImpreVirtu.getValAtr1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valAtr2", FormatUtils.formatObject(facImpreVirtu.getValAtr2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valAtr3", FormatUtils.formatObject(facImpreVirtu.getValAtr3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("AREATEXTO", "valAtr4", FormatUtils.formatObject(facImpreVirtu.getValAtr4(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valTamaBuff", FormatUtils.formatObject(facImpreVirtu.getValTamaBuff(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(facImpreVirtu.getNumSecu() != null){	
			checkCombo("numSecu", FormatUtils.formatObject(facImpreVirtu.getNumSecu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(facImpreVirtu.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Borramos los elementos correspondientes a la internacionalización
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
		/** por eloy mier pérez para agregar funcionalidad de desactivacion de campos */
		traza("MMG: antes de llamar a desactivateNonModifyFields .....");
		desactivateNonModifyFields();
		traza("MMG: despues de llamar a desactivateNonModifyFields ......");
		/** 
			por eloy mier pérez para agregar funcionalidad de desactivacion de campos
			para reescribir funciones ontab y onshtab.
		 */
		cambiarAcciones();
	}

	/**
		Por EMP.
		Nos permite cambiar el evento ontab y onshtab de los objetos druida necesarios en el modo
		de modificación.
	*/
	protected void cambiarAcciones() throws Exception{
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codImpr", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codImpr", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",2, false)");
				asignarAtributo("AREATEXTO", "desImpr", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",3, true)");
				asignarAtributo("AREATEXTO", "desImpr", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",3, false)");
					asignarAtributo("COMBO","tiimOidTipo", "ontab", "ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",4, true)");
					asignarAtributo("COMBO","tiimOidTipo", "onshtab", "ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",4, false)");
				asignarAtributo("TEXT", "indEstaActi", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",5, true)");
				asignarAtributo("TEXT", "indEstaActi", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",5, false)");
				asignarAtributo("AREATEXTO", "valAtr1", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",6, true)");
				asignarAtributo("AREATEXTO", "valAtr1", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",6, false)");
				asignarAtributo("AREATEXTO", "valAtr2", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",7, true)");
				asignarAtributo("AREATEXTO", "valAtr2", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",7, false)");
				asignarAtributo("AREATEXTO", "valAtr3", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",8, true)");
				asignarAtributo("AREATEXTO", "valAtr3", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",8, false)");
				asignarAtributo("AREATEXTO", "valAtr4", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",9, true)");
				asignarAtributo("AREATEXTO", "valAtr4", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",9, false)");
				asignarAtributo("AREATEXTO", "valTamaBuff", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",10, true)");
				asignarAtributo("AREATEXTO", "valTamaBuff", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",10, false)");
				asignarAtributo("TEXT", "numSecu", "ontab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",11, true)");
				asignarAtributo("TEXT", "numSecu", "onshtab","ejecutarAccionFocoModificacion(\"facImpreVirtuFrm\",11, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","facImpreVirtuTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","facImpreVirtuTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de view
	*/
	protected void removeNonViewElements() throws Exception{
		
						borrarCampo("id");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		
						borrarCampo("id");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		borrarCampo("valAtr2");
		borrarCampo("valAtr3");
		borrarCampo("valAtr4");
		borrarCampo("valTamaBuff");
		borrarCampo("numSecu");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificación
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es codImpr...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codImpr");
						asignarAtributo ("TEXT", "codImpr", "disabled", "S");
				traza("MMG: el atributo es desImpr...");		
				
				traza("MMG: el atributo es tiimOidTipo...");		
				
				traza("MMG: el atributo es indEstaActi...");		
				
				traza("MMG: el atributo es valAtr1...");		
				
				traza("MMG: el atributo es valAtr2...");		
				
				traza("MMG: el atributo es valAtr3...");		
				
				traza("MMG: el atributo es valAtr4...");		
				
				traza("MMG: el atributo es valTamaBuff...");		
				
				traza("MMG: el atributo es numSecu...");		
				
		}

	/**
	* Nos permite establecer el tamaño de las capas de la pantalla según el modo
	* Esto se debe a que dependiendo del modo aparecen unos campos u otros 
	*/
	protected void establecerSizeCapas(String accion, String origen) throws Exception{
		//Dependiendo del modo el tamaño del formualrio será uno u otro
		int sizeForm = 0;
		if(accion.equals(ACCION_LOV)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_VIEW)) sizeForm = VIEWFORM_SIZE;
		else if(accion.equals(ACCION_CREATE)) sizeForm = CREATEFORM_SIZE;
		else if(accion.equals(ACCION_REMOVE)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_QUERY)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) sizeForm = UPDATEFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) sizeForm = UPDATEFORM_SIZE;
		
		//Establecemos el tamaño de la capa del formulario
		asignarAtributo("CAPA","facImpreVirtuFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","facImpreVirtuListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","facImpreVirtuListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(FacImpreVirtuData facImpreVirtu) throws Exception{
		HashMap checkedCombos = new HashMap();
		FacTipoImpreData tiimOidTipo = new FacTipoImpreData();
		
						asignarComboResultados(BUSINESSID_TIIMOIDTIPO_QUERY,TIIMOIDTIPO_COMBO_CONNECTOR, 
			tiimOidTipo, tiimOidTipo.clone(), "facTipoImpre", "tiimOidTipo", "result_ROWSET" );
		if(facImpreVirtu != null && facImpreVirtu.getTiimOidTipo() != null){
				checkCombo("tiimOidTipo" , facImpreVirtu.getTiimOidTipo().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param facImpreVirtu La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(FacImpreVirtuData facImpreVirtu) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		FacImpreVirtuData facImpreVirtu = 
			(FacImpreVirtuData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(facImpreVirtu.getTiimOidTipo() != null){
			facImpreVirtu.setTiimOidTipo((es.indra.belcorp.mso.FacTipoImpreData)
			getSingleObject(BUSINESSID_TIIMOIDTIPO_QUERY, 
			facImpreVirtu.getTiimOidTipo(),
			facImpreVirtu.getTiimOidTipo().clone(),
			"facTipoImpre"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(facImpreVirtu);
		loadLeafDependenceCombos(facImpreVirtu);
	}
	
	/**
	*	Por defecto en los campos que tienen la búsqueda por intervalo el label del campo es el label
	*	correspondiente a campos normal (como si no fuera un campo con intervalor). En los modos de busqueda 
	*	(search, update search y remove search) tendremos que poner el label a la búsqueda "desde"
	*/
	protected void setIntervalSearchFromLavels() throws Exception{
	}
	
	/**
	*	Metodo que nos elimina los trs que quedan vacíos por no aparecer sus campos por el modo
	*/
	protected void eliminarTrsVacios(String accion, String origen) throws Exception{
		if(accion.equals(ACCION_QUERY) || accion.equals(ACCION_LOV) ||
			(accion.equals(ACCION_UPDATE) && origen.equals("menu")) ||
			(accion.equals(ACCION_REMOVE) && origen.equals("menu"))){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr6");
			borrarNodo("TR","nombre","formGapTr6");
			borrarNodo("TR","nombre","formTr7");
			borrarNodo("TR","nombre","formGapTr7");
			borrarNodo("TR","nombre","formTr8");
			borrarNodo("TR","nombre","formGapTr8");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			borrarNodo("TR","nombre","formTr10");
			borrarNodo("TR","nombre","formGapTr10");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}
	}
	
	
	
		
}





