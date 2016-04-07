/*
    INDRA/CAR/mmg
    $Id: CarParamCarteLPStartUp.java,v 1.1 2009/12/03 18:43:43 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CarParamCarteLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 678;
	public static final short CREATEFORM_SIZE = 678;
	public static final short UPDATEFORM_SIZE = 678;
	public static final short VIEWFORM_SIZE = 678;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCarParamCarteQueryFromToUserPage";
	public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	public static final String BUSINESSID_GRSOOIDGRUPSOLI_QUERY ="MMGCarGrupoSolicQueryFromToUser";public static final String GRSOOIDGRUPSOLI_COMBO_CONNECTOR = "CarGrupoSolicConectorCombo";
	public static final String BUSINESSID_NIRIOIDNIVERIES_QUERY ="MMGCarNivelRiesgQueryFromToUser";public static final String NIRIOIDNIVERIES_COMBO_CONNECTOR = "CarNivelRiesgConectorCombo";
	public static final String BUSINESSID_INVAOIDINDIVALI_QUERY ="MMGCarIndicValidQueryFromToUser";public static final String INVAOIDINDIVALI_COMBO_CONNECTOR = "CarIndicValidConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CarParamCarteLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CarParamCartePage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("CarParamCarte");
			
			
		
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CarParamCartePage", "cod", "CarParamCarte." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Limpiamos la botonera
			limpiarBotoneraLista("carParamCarte", accion);
			
			
			
			//Ejecutanos la acción solicitada		
			if(accion.equals(ACCION_LOV)) cmdLov();
			else if(accion.equals(ACCION_QUERY)) cmdQuery();
			else if(accion.equals(ACCION_CREATE)) cmdCreate();
			else if(accion.equals(ACCION_REMOVE)) cmdRemove();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) cmdUpdate();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) cmdPreUpdateForm();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) cmdUpdateForm();
			else if(accion.equals(ACCION_VIEW) && origen.equals("pagina")) cmdPreView();
			else if(accion.equals(ACCION_VIEW) && origen.equals("preview")) cmdView();
			
			//Eliminamos los labels del modo view si no estamos en dicho modo. 
			//Si lo estamos, eliminamos los widgets
			if(!accion.equals(ACCION_VIEW)) removeViewLabels();
			else removeWidgets();
			
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
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		asignarAtributo("TEXT", "codConf", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "indDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "numDiasDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		asignarAtributo("TEXT", "indLineCred", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecVigeDesd", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecVigeHast", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valPorcVali", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "indMontMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontMaxiPerm", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indPorcMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valPorc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "numDiasAdic", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "carParamCarteLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CarParamCartePage", "onblur", "window.focus();");
		
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
		conectorAction("CarParamCarteLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		CarParamCarteData carParamCarteQuery= new CarParamCarteData();
		carParamCarteQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CarParamCarteData datosResult = (CarParamCarteData)getSingleObject(BUSINESSID_QUERY, carParamCarteQuery, 
			carParamCarteQuery.clone(), "carParamCarte");
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		setDependenceComboLabels(datosResult);
		
		//Damos los valores a los labels del modo view
		CarParamCarteData carParamCarte = datosResult;
	
	
	
		asignarAtributo("LABELC", "lblViewCodConf", "valor", 
				FormatUtils.formatObject(carParamCarte.getCodConf(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndDeudVenc", "valor", 
				FormatUtils.formatObject(carParamCarte.getIndDeudVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumDiasDeudVenc", "valor", 
				FormatUtils.formatObject(carParamCarte.getNumDiasDeudVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndLineCred", "valor", 
				FormatUtils.formatObject(carParamCarte.getIndLineCred(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecVigeDesd", "valor", 
				FormatUtils.formatObject(carParamCarte.getFecVigeDesd(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecVigeHast", "valor", 
				FormatUtils.formatObject(carParamCarte.getFecVigeHast(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValPorcVali", "valor", 
				FormatUtils.formatObject(carParamCarte.getValPorcVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	/*
		asignarAtributo("LABELC", "lblViewIndVali", "valor", 
				FormatUtils.formatObject(carParamCarte.getIndVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	*/
		asignarAtributo("LABELC", "lblViewIndMontMaxi", "valor", 
				FormatUtils.formatObject(carParamCarte.getIndMontMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValMontMaxiPerm", "valor", 
				FormatUtils.formatObject(carParamCarte.getValMontMaxiPerm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndPorcMaxi", "valor", 
				FormatUtils.formatObject(carParamCarte.getIndPorcMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValPorc", "valor", 
				FormatUtils.formatObject(carParamCarte.getValPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewNumDiasAdic", "valor", 
				FormatUtils.formatObject(carParamCarte.getNumDiasAdic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
	
	
	
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeLocalizationElements();
		removeNonViewElements();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
	
		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "grsoOidGrupSoli", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRies", "req", "S");
		asignarAtributo("TEXT", "codConf", "req", "S");
		asignarAtributo("TEXT", "indDeudVenc", "req", "S");
		asignarAtributo("TEXT", "indLineCred", "req", "S");
		asignarAtributo("TEXT", "indMontMaxi", "req", "S");
		asignarAtributo("TEXT", "indPorcMaxi", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		asignarAtributo("TEXT", "codConf", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "indDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "numDiasDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		asignarAtributo("TEXT", "indLineCred", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecVigeDesd", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecVigeHast", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valPorcVali", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "indMontMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontMaxiPerm", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indPorcMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valPorc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "numDiasAdic", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
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

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		asignarAtributo("TEXT", "codConf", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "indDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "numDiasDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		asignarAtributo("TEXT", "indLineCred", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecVigeDesd", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecVigeHast", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valPorcVali", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "indMontMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontMaxiPerm", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indPorcMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valPorc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "numDiasAdic", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Eliminamos los elementos correspondientes a la internacionalizacion y lov
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
	}

	/**Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
		
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		asignarAtributo("TEXT", "codConf", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "indDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "numDiasDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		asignarAtributo("TEXT", "indLineCred", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecVigeDesd", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecVigeHast", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valPorcVali", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "indMontMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontMaxiPerm", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indPorcMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valPorc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "numDiasAdic", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el botón lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
			
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		asignarAtributo("TEXT", "codConf", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "indDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "numDiasDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		asignarAtributo("TEXT", "indLineCred", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecVigeDesd", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecVigeHast", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valPorcVali", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "indMontMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontMaxiPerm", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indPorcMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valPorc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "numDiasAdic", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Simplemente elimnamos el botón lov de null selection y la internacionalización
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
	}

	
	/**Acción previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("CarParamCarteLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
	}
	
	/**Prepara el formualrio para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "carParamCarteFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "grsoOidGrupSoli", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRies", "req", "S");
		asignarAtributo("TEXT", "codConf", "req", "S");
		asignarAtributo("TEXT", "indDeudVenc", "req", "S");
		asignarAtributo("TEXT", "indLineCred", "req", "S");
		asignarAtributo("TEXT", "indMontMaxi", "req", "S");
		asignarAtributo("TEXT", "indPorcMaxi", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		
		
		asignarAtributo("TEXT", "codConf", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "indDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "numDiasDeudVenc", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		asignarAtributo("TEXT", "indLineCred", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecVigeDesd", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "fecVigeHast", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valPorcVali", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 1)");
		asignarAtributo("TEXT", "indMontMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontMaxiPerm", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indPorcMaxi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valPorc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((5 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "numDiasAdic", "validacion", "ValidaInt(cdos_trim(valor), 3, 0, 999)");
		
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CarParamCarte");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CarParamCarteData carParamCarteQuery= new CarParamCarteData();
		carParamCarteQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		CarParamCarteData  datosResult = (CarParamCarteData)getSingleObject(BUSINESSID_QUERY, carParamCarteQuery, 
			carParamCarteQuery.clone(), "carParamCarte");

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos();
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CarParamCarteData carParamCarte = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.SegPaisData paisOidPais = carParamCarte.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
	
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoli = carParamCarte.getGrsoOidGrupSoli();
		if(grsoOidGrupSoli != null && grsoOidGrupSoli.getId() != null) checkCombo("grsoOidGrupSoli" , grsoOidGrupSoli.getId().toString());
	
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRies = carParamCarte.getNiriOidNiveRies();
		if(niriOidNiveRies != null && niriOidNiveRies.getId() != null) checkCombo("niriOidNiveRies" , niriOidNiveRies.getId().toString());
	
		asignar("TEXT", "codConf", FormatUtils.formatObject(carParamCarte.getCodConf(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indDeudVenc", FormatUtils.formatObject(carParamCarte.getIndDeudVenc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numDiasDeudVenc", FormatUtils.formatObject(carParamCarte.getNumDiasDeudVenc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indLineCred", FormatUtils.formatObject(carParamCarte.getIndLineCred(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecVigeDesd", FormatUtils.formatObject(carParamCarte.getFecVigeDesd(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecVigeHast", FormatUtils.formatObject(carParamCarte.getFecVigeHast(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valPorcVali", FormatUtils.formatObject(carParamCarte.getValPorcVali(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	/*
		asignar("TEXT", "indVali", FormatUtils.formatObject(carParamCarte.getIndVali(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	*/
		asignar("TEXT", "indMontMaxi", FormatUtils.formatObject(carParamCarte.getIndMontMaxi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valMontMaxiPerm", FormatUtils.formatObject(carParamCarte.getValMontMaxiPerm(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indPorcMaxi", FormatUtils.formatObject(carParamCarte.getIndPorcMaxi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valPorc", FormatUtils.formatObject(carParamCarte.getValPorc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "numDiasAdic", FormatUtils.formatObject(carParamCarte.getNumDiasAdic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		es.indra.belcorp.mso.CarIndicValidData invaOidIndiVali = carParamCarte.getInvaOidIndiVali();
		if(invaOidIndiVali != null && invaOidIndiVali.getId() != null) checkCombo("invaOidIndiVali" , invaOidIndiVali.getId().toString());
	
	

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(carParamCarte.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Borramos los elementos correspondientes a la internacionalización
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
	}
	
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
		
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","carParamCarteTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","carParamCarteTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonViewElements() throws Exception{
		borrarCampo("id");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		borrarCampo("id");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
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
		asignarAtributo("CAPA","carParamCarteFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","carParamCartePreListLayer", "y", String.valueOf(sizeForm + 24));
		asignarAtributo("CAPA","carParamCarteListLayer", "y", String.valueOf(sizeForm + 46));		
		asignarAtributo("CAPA","carParamCarteListButtonsLayer", "y", String.valueOf(sizeForm + 299));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos() throws Exception{
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, new BelFormaPagoTaponData(), new BelFormaPagoTaponData(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_GRSOOIDGRUPSOLI_QUERY,GRSOOIDGRUPSOLI_COMBO_CONNECTOR, new CarGrupoSolicData(), new CarGrupoSolicData(), "carGrupoSolic", "grsoOidGrupSoli", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_NIRIOIDNIVERIES_QUERY,NIRIOIDNIVERIES_COMBO_CONNECTOR, new CarNivelRiesgData(), new CarNivelRiesgData(), "carNivelRiesg", "niriOidNiveRies", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_INVAOIDINDIVALI_QUERY,INVAOIDINDIVALI_COMBO_CONNECTOR, new CarIndicValidData(), new CarIndicValidData(), "carIndicValid", "invaOidIndiVali", "result_ROWSET" );
		
			
		//Seleccionamos en los combos de enitdades estructurales el valor asociado al usuario
		/*String paisOidPais = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPais");
		if(paisOidPais != null && !paisOidPais.trim().equals("")) checkCombo("paisOidPais", paisOidPais);
		
		*/
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param carParamCarte La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CarParamCarteData carParamCarte) 
		throws Exception{
		if(carParamCarte.getPaisOidPais() != null){
			SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setFopaOidFormPago(carParamCarte.getPaisOidPais().getFopaOidFormPago());
			paisOidPais.setMoneOidMoneAlt(carParamCarte.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setMoneOidMone(carParamCarte.getPaisOidPais().getMoneOidMone());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , carParamCarte.getPaisOidPais().getId().toString());
			checkCombo("paisOidPais_fopaOidFormPago" , carParamCarte.getPaisOidPais().getFopaOidFormPago().getId().toString());
			checkCombo("paisOidPais_moneOidMoneAlt" , carParamCarte.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			checkCombo("paisOidPais_moneOidMone" , carParamCarte.getPaisOidPais().getMoneOidMone().getId().toString());
			}
		if(carParamCarte.getGrsoOidGrupSoli() != null){
			checkCombo("grsoOidGrupSoli" , carParamCarte.getGrsoOidGrupSoli().getId().toString());
			}
		if(carParamCarte.getNiriOidNiveRies() != null){
			checkCombo("niriOidNiveRies" , carParamCarte.getNiriOidNiveRies().getId().toString());
			}
		if(carParamCarte.getInvaOidIndiVali() != null){
			checkCombo("invaOidIndiVali" , carParamCarte.getInvaOidIndiVali().getId().toString());
			}
		
	}
	
	/**
	* Este método nos permite establecer el valor de los labels de una jerarquái de dependencia
	*/
	protected void setDependenceComboLabels(CarParamCarteData carParamCarte) 
		throws Exception{
		asignarAtributo("LABELC", "lblViewPaisOidPais_fopaOidFormPago", "valor",FormatUtils.formatObject(carParamCarte.getPaisOidPais().getFopaOidFormPago()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMoneAlt", "valor",FormatUtils.formatObject(carParamCarte.getPaisOidPais().getMoneOidMoneAlt()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMone", "valor",FormatUtils.formatObject(carParamCarte.getPaisOidPais().getMoneOidMone()));
		asignarAtributo("LABELC", "lblViewPaisOidPais", "valor",FormatUtils.formatObject(carParamCarte.getPaisOidPais()));
		asignarAtributo("LABELC", "lblViewGrsoOidGrupSoli", "valor",FormatUtils.formatObject(carParamCarte.getGrsoOidGrupSoli()));
		asignarAtributo("LABELC", "lblViewNiriOidNiveRies", "valor",FormatUtils.formatObject(carParamCarte.getNiriOidNiveRies()));
		asignarAtributo("LABELC", "lblViewInvaOidIndiVali", "valor",FormatUtils.formatObject(carParamCarte.getInvaOidIndiVali()));
		
			
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CarParamCarteData carParamCarte = 
			(CarParamCarteData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(carParamCarte.getPaisOidPais() != null){
			carParamCarte.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			carParamCarte.getPaisOidPais(),
			carParamCarte.getPaisOidPais().clone(),
			"segPais"));
		}
		if(carParamCarte.getGrsoOidGrupSoli() != null){
			carParamCarte.setGrsoOidGrupSoli((es.indra.belcorp.mso.CarGrupoSolicData)
			getSingleObject(BUSINESSID_GRSOOIDGRUPSOLI_QUERY, 
			carParamCarte.getGrsoOidGrupSoli(),
			carParamCarte.getGrsoOidGrupSoli().clone(),
			"carGrupoSolic"));
		}
		if(carParamCarte.getNiriOidNiveRies() != null){
			carParamCarte.setNiriOidNiveRies((es.indra.belcorp.mso.CarNivelRiesgData)
			getSingleObject(BUSINESSID_NIRIOIDNIVERIES_QUERY, 
			carParamCarte.getNiriOidNiveRies(),
			carParamCarte.getNiriOidNiveRies().clone(),
			"carNivelRiesg"));
		}
		if(carParamCarte.getInvaOidIndiVali() != null){
			carParamCarte.setInvaOidIndiVali((es.indra.belcorp.mso.CarIndicValidData)
			getSingleObject(BUSINESSID_INVAOIDINDIVALI_QUERY, 
			carParamCarte.getInvaOidIndiVali(),
			carParamCarte.getInvaOidIndiVali().clone(),
			"carIndicValid"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(carParamCarte);
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
	
	/**
	*	Este método nos permite eliminar los labels del modo view de la pantalla
	*/
	protected void removeViewLabels() throws Exception{
		borrarNodo("TR", "nombre", "idViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPaisViewLabelTrId");
		borrarNodo("TR", "nombre", "grsoOidGrupSoliViewLabelTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesViewLabelTrId");
		borrarNodo("TR", "nombre", "codConfViewLabelTrId");
		borrarNodo("TR", "nombre", "indDeudVencViewLabelTrId");
		borrarNodo("TR", "nombre", "numDiasDeudVencViewLabelTrId");
		borrarNodo("TR", "nombre", "indLineCredViewLabelTrId");
		borrarNodo("TR", "nombre", "fecVigeDesdViewLabelTrId");
		borrarNodo("TR", "nombre", "fecVigeHastViewLabelTrId");
		borrarNodo("TR", "nombre", "valPorcValiViewLabelTrId");
		borrarNodo("TR", "nombre", "indValiViewLabelTrId");
		borrarNodo("TR", "nombre", "indMontMaxiViewLabelTrId");
		borrarNodo("TR", "nombre", "valMontMaxiPermViewLabelTrId");
		borrarNodo("TR", "nombre", "indPorcMaxiViewLabelTrId");
		borrarNodo("TR", "nombre", "valPorcViewLabelTrId");
		borrarNodo("TR", "nombre", "numDiasAdicViewLabelTrId");
		borrarNodo("TR", "nombre", "invaOidIndiValiViewLabelTrId");
		
	}

	/**
	*	Nos permite borrar los TR que contienen los widgets de los campos
	*/
	protected void removeWidgets() throws Exception{
		borrarNodo("TR", "nombre", "idWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPaisWidgetTrId");
		borrarNodo("TR", "nombre", "grsoOidGrupSoliWidgetTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesWidgetTrId");
		borrarNodo("TR", "nombre", "codConfWidgetTrId");
		borrarNodo("TR", "nombre", "indDeudVencWidgetTrId");
		borrarNodo("TR", "nombre", "numDiasDeudVencWidgetTrId");
		borrarNodo("TR", "nombre", "indLineCredWidgetTrId");
		borrarNodo("TR", "nombre", "fecVigeDesdWidgetTrId");
		borrarNodo("TR", "nombre", "fecVigeHastWidgetTrId");
		borrarNodo("TR", "nombre", "valPorcValiWidgetTrId");
		borrarNodo("TR", "nombre", "indValiWidgetTrId");
		borrarNodo("TR", "nombre", "indMontMaxiWidgetTrId");
		borrarNodo("TR", "nombre", "valMontMaxiPermWidgetTrId");
		borrarNodo("TR", "nombre", "indPorcMaxiWidgetTrId");
		borrarNodo("TR", "nombre", "valPorcWidgetTrId");
		borrarNodo("TR", "nombre", "numDiasAdicWidgetTrId");
		borrarNodo("TR", "nombre", "invaOidIndiValiWidgetTrId");
		
	}
}







