/*
    INDRA/CAR/mmg
    $Id: MMGConstants.java,v 1.1 2003/08/25 08:50:19 sahernan Exp $
    Constantes usadas por las LPs de MMG

    DRUIDATARGET=/install/cvsiniciales
*/
package es.indra.druida.belcorp;

// Definicion del interface
public interface MMGConstants{
	//Conastantes que definene los parámetros de entrada a las lps
	public static final String PARAMETRO_GENERICO_ACCION = "accion";
	public static final String PARAMETRO_GENERICO_ORIGEN = "origen";
	public static final String PARAMETRO_GENERICO_REQUERY = "requery";
	public static final String PARAMETRO_LOV_ATTRIBUTO = "lovatribute";
	public static final String PARAMETRO_LOV_ENTIDAD = "loventity";
	public static final String PARAMETRO_VIEW_ID ="id";
	public static final String PARAMETRO_CODIGO_ERROR="errCodigo";
	public static final String PARAMETRO_IDIOMA = "idioma";
	public static final String PARAMETRO_PAIS = "pais";
	public static final String PARAMETRO_ERRORINFO_EXTRA = "errorExtraInfo";
	public static final String PARAMETRO_MENU_ID_FUNCION = "idFuncion";
	public static final String PARAMETRO_MENU_FROM_MENU = "fromMenu";
	public static final String PARAMETRO_MENU_CDOS_IDIOMA = "cdosIdioma";
	public static final String PARAMETRO_ERROR_INFO = "errorInfo";

	//Constantes que definenen las pòsibles acciones a ejecutar
	public static final String ACCION_LOV = "lov";
	public static final String ACCION_VIEW = "view";
	public static final String ACCION_CREATE = "create";
	public static final String ACCION_REMOVE = "remove";
	public static final String ACCION_QUERY = "query";
	public static final String ACCION_UPDATE = "update";

	//Constantes que definene propeidades del usuario
	public static final String USER_PROPERTIES = "propiedades";
	public static final String USER_PROPERTY_DATE_PATTERN ="FormatoFecha";
	public static final String USER_PROPERTY_DECIMAL_SEPARATOR ="FormatoNumericoSeparadorDecimales";
	public static final String USER_PROPERTY_GROUPING_SEPARATOR = "FormatoNumericoSeparadorMiles";
	public static final String USER_PROPERTY_DECIMAL_PRECISION = "FormatoNumerico";
	public static final String USER_PROPERTY_LANGUAGE ="Idioma";
	public static final String USER_PROPERTY_COUNTRY = "Pais";
	public static final String USER_PROPERTY_SOCIEDAD = "Sociedad";
	public static final String USER_PROPERTY_MARCA = "Marca";
	public static final String USER_PROPERTY_CANAL = "Canal";
	public static final String USER_PROPERTY_ACCESO = "Acceso";
	public static final String USER_PROPERTY_SUBACCESO = "Subacceso";
	public static final String USER_PROPERTY_SUBGERENCIA_VENTA = "SubgerenciaVentas";
	public static final String USER_PROPERTY_REGION = "Region";
	public static final String USER_PROPERTY_ZONA = "Zona";
	public static final String USER_PROPERTY_SECCION = "Seccion";
	public static final String USER_PROPERTY_TERRITORIO = "Territorio";
	public static final String USER_PROPERTY_COUNTRY_DEFAULT = "PaisDefecto";
	public static final String USER_PROPERTY_SOCIEDAD_DEFAULT = "SociedadPorDefecto";
	public static final String USER_PROPERTY_MARCA_DEFAULT = "MarcaPorDefecto";
	public static final String USER_PROPERTY_CANAL_DEFAULT = "CanalPorDefecto";
	public static final String USER_PROPERTY_ACCESO_DEFAULT = "AccesoPorDefecto";
	public static final String USER_PROPERTY_SUBACCESO_DEFAULT = "SubaccesoPorDefecto";
	public static final String USER_PROPERTY_SUBGERENCIA_VENTA_DEFAULT = "SubgerenciaVentasDefecto";
	public static final String USER_PROPERTY_REGION_DEFAULT = "RegionPorDefecto";
	public static final String USER_PROPERTY_ZONA_DEFAULT = "ZonaPorDefecto";
	public static final String USER_PROPERTY_SECCION_DEFAULT = "SeccionDefecto";
	public static final String USER_PROPERTY_TERRITORIO_DEFAULT = "TerritorioPorDefecto";
	
	//Constantes que definene elementos de la presentanción
	public static final String DATE_PATTERN ="datePattern";
	public static final String DECIMAL_SEPARATOR ="decimalSeparator";
	public static final String VAR_IDIOMA = "userLanguageCode";
	public static final String VAR_IDIOMA_XML = "pageLaguage"; 
	public static final String VAR_LAST_QUERY_TO_SESSION = "lastQueryToSession";
	public static final String VAR_ACCION_ANTERIOR = "previousAction";
	public static final String VAR_PERFORM_REQUERY = "performRequery";
	public static final String VAR_DEFAULT_LANGUAGE_CODE = "defaultLanguageCode";
	public static final String VAR_APPLY_STRUCTURAL_ENTITY = "applyStructuralEntity";
	public static final String VAR_COUNTRY_DEFAULT = "structuralDefaultPais";
	public static final String VAR_SOCIEDAD_DEFAULT = "structuralDefaultSociedad";
	public static final String VAR_MARCA_DEFAULT = "structuralDefaultMarca";
	public static final String VAR_CANAL_DEFAULT = "structuralDefaultCanal";
	public static final String VAR_ACCESO_DEFAULT = "structuralDefaultAcceso";
	public static final String VAR_SUBACCESO_DEFAULT = "structuralDefaultSubacceso";
	public static final String VAR_SUBGERENCIA_VENTA_DEFAULT = "structuralDefaultSubgerenciaVentas";
	public static final String VAR_REGION_DEFAULT = "structuralDefaultRegion";
	public static final String VAR_ZONA_DEFAULT = "structuralDefaultZona";
	public static final String VAR_SECCION_DEFAULT = "structuralDefaultSeccion";
	public static final String VAR_TERRITORIO_DEFAULT = "structuralDefaultTerritorio";
	public static final String VAR_CLIENTE_CODE_SIZE = "clientCodeSize";	
	
	//Constantes que definene atriburos almacenados en la session
	public static final String SESSION_ATTRIBUTE_LAST_QUERY = "MMGSessinAtributeLastQuery";
	public static final String SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM = "MMGSessinAtributeLastQueryObjFrom";
	public static final String SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO = "MMGSessinAtributeLastQueryObjTo";
	public static final String SESSION_ATTRIBUTE_REQUERY = "MMGSessionAttributeRequery";
	public static final String SESSION_ATTRIBUTE_LANGUAGE_CDOS = "cdosIdioma";
	public static final String SESSION_ATTRIBUTE_LANGUAGE_DRUIDA = "DruidaLang";
	
	//Constantes usadas en los elementos de presentación
	public static final String ENTITY_SEPARATOR = "<--ENTITY_SEPARATOR-->";
	public static final String ATTRIBUTE_SEPARATOR = "<--ATTRIBUTE_SEPARATOR-->";
	
	//Conectores genéricos MMG
	public static final String MMG_UPDATE_CONNECTOR = "MMGExecuteUpdateConnector";
	public static final String MMG_QUERY_CONNECTOR = "MMGExecuteQueryConnector";
	
	//Elementos de lógica de negocios 
	public static final String BUSINESID_GENDETASICC = "MMGGenDetaSiccQueryFromToUser";
	
	//Paginas xml
	public static final String MMG_INDEX_PAGE = "MMGIndex";
	public static final String MMG_CLOSE_DIALOG_PAGE = "MMGCloseDialog";
	public static final String MMG_ERROR_DIALOG_TRIGGER_PAGE = "MMGErrorDialogTriger";
	
	//Cosntantes usadas para definir lps
	public static final String LP_PANTALLA_ERROR = "MMGLPPantallaError";
	public static final String LP_CLOSE_DIALOG = "MMGLPCloseDialog";
	public static final String LP_ERROR_DIALOG_TRIGGER = "MMGLPErrorDialogTrigger";
	
	//Constanetes que definene los campos de la pagina del disparador del dialogo de error
	public static final String ERROR_DIALOG_TRIGGER_CODE = "errCodigo";
	public static final String ERROR_DIALOG_TRIGGER_DESCRIPTION = "errDescripcion";
	public static final String ERROR_DIALOG_TRIGGER_SEVERITY = "errSeverity";
	
	//Codigos de error
	public static final int ERRORCODE_DESCONOCIDO = 0;
	public static final int ERRORCODE_NO_SESSION = 500010001;
	public static final int ERRORCODE_NO_USER_LANGUAGE = 500010002;
	public static final int ERRORCODE_NO_USER_DATEPATTER = 500010003;
	public static final int ERRORCODE_NO_USER_DECIMALSEPARATOR= 500010004;
	public static final int ERRORCODE_ELEMENTO_INEXISTENTE = 500010005;
	public static final int ERRORCODE_NO_DEFAULT_LANGUAGE = 500010006;
	public static final int ERRORCODE_NO_DEFAULT_COUNTRY = 500010007;
	public static final int ERRORCODE_UNIQUE_KEY_VIOLATED = 500010008;
	public static final int ERRORCODE_OBJECT_MODIFIED = 500010009;
	public static final int ERRORCODE_REFERENTIAL_INTEGRITY = 500010010;
	public static final int ERRORCODE_NO_USER_GROUPINGSEPARATOR = 500010011;
	public static final int ERRORCODE_NO_USER_COUNTRY = 500010012;
	public static final int ERRORCODE_INVALID_BIND = 500010013;
	
	//EL valor del idioma por defecto
	public static final int DEFAULT_LANGUAGE_CODE = 1;
	
	//Umbral de longitud entre text y textareas en campos internacionalizables
	public static final short LOCALIZATION_THRESHOLD = 40;
	
	//Los codigos de error sql de oracle
	public static final int SQLERROR_UNIQUE_CONSTRAIN_VIOLATED = 1;
}


