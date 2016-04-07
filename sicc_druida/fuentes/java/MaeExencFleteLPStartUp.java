/*
    INDRA/CAR/mmg
    $Id: MaeExencFleteLPStartUp.java,v 1.1 2009/12/03 18:36:23 pecbazalar Exp $
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
public class MaeExencFleteLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 147;
	public static final short CREATEFORM_SIZE = 129;
	public static final short UPDATEFORM_SIZE = 129;
	public static final short VIEWFORM_SIZE = 129;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGMaeExencFleteQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
				public static final String BUSINESSID_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienQueryFromToUser";
				public static final String TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienConectorCombo";
	
				public static final String BUSINESSID_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienViewQueryFromToUser";
				public static final String SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienViewConectorCombo";
	
				public static final String BUSINESSID_TCCLOIDTIPOCLAS_QUERY ="MMGMaeTipoClasiClienViewQueryFromToUser";
				public static final String TCCLOIDTIPOCLAS_COMBO_CONNECTOR = "MaeTipoClasiClienViewConectorCombo";
	
				public static final String BUSINESSID_CLASOIDCLAS_QUERY ="MMGMaeClasiViewQueryFromToUser";
				public static final String CLASOIDCLAS_COMBO_CONNECTOR = "MaeClasiViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	protected static Hashtable indExenFletValues = new Hashtable();
	static{
		indExenFletValues.put(new java.lang.String("1"), "Activo");
		indExenFletValues.put(new java.lang.String("0"), "Inactivo");
	}
	
	
	// Definicion del constructor
	public MaeExencFleteLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("MaeExencFletePage");
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
			buildJsPageSize("MaeExencFlete");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "MaeExencFletePage", "cod", "MaeExencFlete." + accion + ".label");
			
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
			limpiarBotoneraLista("maeExencFlete", accion);
			
			
			
			
			
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
		
		
		
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "maeExencFleteLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "MaeExencFletePage", "onblur", "window.focus();");
		
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
		conectorAction("MaeExencFleteLPStartUp");
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
		MaeExencFleteData maeExencFleteQuery= new MaeExencFleteData();
		maeExencFleteQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		MaeExencFleteData datosResult = (MaeExencFleteData)getSingleObject(BUSINESSID_QUERY, maeExencFleteQuery, 
			maeExencFleteQuery.clone(), "maeExencFlete");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndExenFlet() != null)
			asignar("VAR", "indExenFletCheckValue", datosResult.getIndExenFlet().toString());
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		MaeExencFleteData maeExencFlete = datosResult;
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClie = maeExencFlete.getTiclOidTipoClie();
		if(ticlOidTipoClie != null && ticlOidTipoClie.getId() != null) checkCombo("ticlOidTipoClie" , ticlOidTipoClie.getId().toString());
		es.indra.belcorp.mso.MaeSubtiClienViewData sbtiOidSubtClie = maeExencFlete.getSbtiOidSubtClie();
		if(sbtiOidSubtClie != null && sbtiOidSubtClie.getId() != null) checkCombo("sbtiOidSubtClie" , sbtiOidSubtClie.getId().toString());
		es.indra.belcorp.mso.MaeTipoClasiClienViewData tcclOidTipoClas = maeExencFlete.getTcclOidTipoClas();
		if(tcclOidTipoClas != null && tcclOidTipoClas.getId() != null) checkCombo("tcclOidTipoClas" , tcclOidTipoClas.getId().toString());
		es.indra.belcorp.mso.MaeClasiViewData clasOidClas = maeExencFlete.getClasOidClas();
		if(clasOidClas != null && clasOidClas.getId() != null) checkCombo("clasOidClas" , clasOidClas.getId().toString());
		asignarAtributo("RADIOB", "indExenFlet" , "valor", FormatUtils.formatObject(
			maeExencFlete.getIndExenFlet(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
					asignarAtributo("COMBO", "ticlOidTipoClie", "disabled", "S");
					asignarAtributo("COMBO", "sbtiOidSubtClie", "disabled", "S");
					asignarAtributo("COMBO", "tcclOidTipoClas", "disabled", "S");
					asignarAtributo("COMBO", "clasOidClas", "disabled", "S");
					asignarAtributo("RADIOB", "indExenFlet", "disabled", "S");
		
		
	
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
		asignarAtributo("COMBO", "ticlOidTipoClie", "req", "S");
		asignarAtributo("RADIOB", "indExenFlet", "req", "S");
		
		
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
		conectorAction("MaeExencFleteLPStartUp");
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
		//asignarAtributo("FORMULARIO", "maeExencFleteFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "ticlOidTipoClie", "req", "S");
				asignarAtributo("RADIOB", "indExenFlet", "req", "S");
		
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
		
			
			
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando MaeExencFlete");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		MaeExencFleteData maeExencFleteQuery= new MaeExencFleteData();
		maeExencFleteQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		MaeExencFleteData  datosResult = (MaeExencFleteData)getSingleObject(BUSINESSID_QUERY, maeExencFleteQuery, 
			maeExencFleteQuery.clone(), "maeExencFlete");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndExenFlet() != null)
			asignar("VAR", "indExenFletCheckValue", datosResult.getIndExenFlet().toString());
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		MaeExencFleteData maeExencFlete = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClie = maeExencFlete.getTiclOidTipoClie();
		if(ticlOidTipoClie != null && ticlOidTipoClie.getId() != null) checkCombo("ticlOidTipoClie" , ticlOidTipoClie.getId().toString());
		es.indra.belcorp.mso.MaeSubtiClienViewData sbtiOidSubtClie = maeExencFlete.getSbtiOidSubtClie();
		if(sbtiOidSubtClie != null && sbtiOidSubtClie.getId() != null) checkCombo("sbtiOidSubtClie" , sbtiOidSubtClie.getId().toString());
		es.indra.belcorp.mso.MaeTipoClasiClienViewData tcclOidTipoClas = maeExencFlete.getTcclOidTipoClas();
		if(tcclOidTipoClas != null && tcclOidTipoClas.getId() != null) checkCombo("tcclOidTipoClas" , tcclOidTipoClas.getId().toString());
		es.indra.belcorp.mso.MaeClasiViewData clasOidClas = maeExencFlete.getClasOidClas();
		if(clasOidClas != null && clasOidClas.getId() != null) checkCombo("clasOidClas" , clasOidClas.getId().toString());
		asignarAtributo("RADIOB", "indExenFlet" , "valor", FormatUtils.formatObject(
			maeExencFlete.getIndExenFlet(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(maeExencFlete.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",1, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",2, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",2, false)");
					asignarAtributo("COMBO","ticlOidTipoClie", "ontab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",3, true)");
					asignarAtributo("COMBO","ticlOidTipoClie", "onshtab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",3, false)");
					asignarAtributo("COMBO","sbtiOidSubtClie", "ontab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",4, true)");
					asignarAtributo("COMBO","sbtiOidSubtClie", "onshtab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",4, false)");
					asignarAtributo("COMBO","tcclOidTipoClas", "ontab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",5, true)");
					asignarAtributo("COMBO","tcclOidTipoClas", "onshtab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",5, false)");
					asignarAtributo("COMBO","clasOidClas", "ontab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",6, true)");
					asignarAtributo("COMBO","clasOidClas", "onshtab", "ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",6, false)");
				asignarAtributo("TEXT", "indExenFlet", "ontab","ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",7, true)");
				asignarAtributo("TEXT", "indExenFlet", "onshtab","ejecutarAccionFocoModificacion(\"maeExencFleteFrm\",7, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","maeExencFleteTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","maeExencFleteTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
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
	* modo de inserción
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
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificación
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es ticlOidTipoClie...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "ticlOidTipoClie", "disabled", "S");
				traza("MMG: el atributo es sbtiOidSubtClie...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "sbtiOidSubtClie", "disabled", "S");
				traza("MMG: el atributo es tcclOidTipoClas...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "tcclOidTipoClas", "disabled", "S");
				traza("MMG: el atributo es clasOidClas...");		
				
				traza("MMG: el atributo es indExenFlet...");		
				
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
		asignarAtributo("CAPA","maeExencFleteFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","maeExencFleteListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","maeExencFleteListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(MaeExencFleteData maeExencFlete) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(maeExencFlete != null && maeExencFlete.getPaisOidPais() != null){
				checkCombo("paisOidPais" , maeExencFlete.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		MaeTipoClienData ticlOidTipoClie = new MaeTipoClienData();
		
						asignarComboResultados(BUSINESSID_TICLOIDTIPOCLIE_QUERY,TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
			ticlOidTipoClie, ticlOidTipoClie.clone(), "maeTipoClien", "ticlOidTipoClie", "result_ROWSET" );
		if(maeExencFlete != null && maeExencFlete.getTiclOidTipoClie() != null){
				checkCombo("ticlOidTipoClie" , maeExencFlete.getTiclOidTipoClie().getId().toString());
			}
		MaeSubtiClienViewData sbtiOidSubtClie = new MaeSubtiClienViewData();
		
						asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_QUERY,SBTIOIDSUBTCLIE_COMBO_CONNECTOR, 
			sbtiOidSubtClie, sbtiOidSubtClie.clone(), "maeSubtiClienView", "sbtiOidSubtClie", "result_ROWSET" );
		if(maeExencFlete != null && maeExencFlete.getSbtiOidSubtClie() != null){
				checkCombo("sbtiOidSubtClie" , maeExencFlete.getSbtiOidSubtClie().getId().toString());
			}
		MaeTipoClasiClienViewData tcclOidTipoClas = new MaeTipoClasiClienViewData();
		
						asignarComboResultados(BUSINESSID_TCCLOIDTIPOCLAS_QUERY,TCCLOIDTIPOCLAS_COMBO_CONNECTOR, 
			tcclOidTipoClas, tcclOidTipoClas.clone(), "maeTipoClasiClienView", "tcclOidTipoClas", "result_ROWSET" );
		if(maeExencFlete != null && maeExencFlete.getTcclOidTipoClas() != null){
				checkCombo("tcclOidTipoClas" , maeExencFlete.getTcclOidTipoClas().getId().toString());
			}
		MaeClasiViewData clasOidClas = new MaeClasiViewData();
		
						asignarComboResultados(BUSINESSID_CLASOIDCLAS_QUERY,CLASOIDCLAS_COMBO_CONNECTOR, 
			clasOidClas, clasOidClas.clone(), "maeClasiView", "clasOidClas", "result_ROWSET" );
		if(maeExencFlete != null && maeExencFlete.getClasOidClas() != null){
				checkCombo("clasOidClas" , maeExencFlete.getClasOidClas().getId().toString());
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
	* @param maeExencFlete La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(MaeExencFleteData maeExencFlete) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		MaeExencFleteData maeExencFlete = 
			(MaeExencFleteData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(maeExencFlete.getPaisOidPais() != null){
			maeExencFlete.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			maeExencFlete.getPaisOidPais(),
			maeExencFlete.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(maeExencFlete.getTiclOidTipoClie() != null){
			maeExencFlete.setTiclOidTipoClie((es.indra.belcorp.mso.MaeTipoClienData)
			getSingleObject(BUSINESSID_TICLOIDTIPOCLIE_QUERY, 
			maeExencFlete.getTiclOidTipoClie(),
			maeExencFlete.getTiclOidTipoClie().clone(),
			"maeTipoClien"));
		}
		if(maeExencFlete.getSbtiOidSubtClie() != null){
			maeExencFlete.setSbtiOidSubtClie((es.indra.belcorp.mso.MaeSubtiClienViewData)
			getSingleObject(BUSINESSID_SBTIOIDSUBTCLIE_QUERY, 
			maeExencFlete.getSbtiOidSubtClie(),
			maeExencFlete.getSbtiOidSubtClie().clone(),
			"maeSubtiClienView"));
		}
		if(maeExencFlete.getTcclOidTipoClas() != null){
			maeExencFlete.setTcclOidTipoClas((es.indra.belcorp.mso.MaeTipoClasiClienViewData)
			getSingleObject(BUSINESSID_TCCLOIDTIPOCLAS_QUERY, 
			maeExencFlete.getTcclOidTipoClas(),
			maeExencFlete.getTcclOidTipoClas().clone(),
			"maeTipoClasiClienView"));
		}
		if(maeExencFlete.getClasOidClas() != null){
			maeExencFlete.setClasOidClas((es.indra.belcorp.mso.MaeClasiViewData)
			getSingleObject(BUSINESSID_CLASOIDCLAS_QUERY, 
			maeExencFlete.getClasOidClas(),
			maeExencFlete.getClasOidClas().clone(),
			"maeClasiView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(maeExencFlete);
		loadLeafDependenceCombos(maeExencFlete);
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





