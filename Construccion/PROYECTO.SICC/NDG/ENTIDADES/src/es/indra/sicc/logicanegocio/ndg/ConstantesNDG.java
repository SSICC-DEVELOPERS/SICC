package es.indra.sicc.logicanegocio.ndg;

/*****************
  Autor: Juan Pablo Sabadini
  Fecha: 11/11/2004
  Se agregaron las constantes: PED_LOTE_COD_PAIS , PED_LOTE_MARCA, PED_LOTE_CANAL
  Se modificaron las constantes: PED_LOTE_TIPO_SOLICITUD, PED_LOTE_PERIODO
*******************/
  
public class ConstantesNDG  {

  public static String NDG_GUI_BUNDLE = "es.indra.sicc.ndg.utils.properties.ndg_gui";
  public static String NDG_ERRORS_BUNDLE = "es.indra.sicc.ndg.utils.properties.ndg_errors";
  public static String NDG_MENSAJES_BUNDLE = "es.indra.sicc.ndg.utils.properties.ndg_mensajes";

  public static String NDG_ERROR_NO_DOCUMENTADO = "Error no documentado";
  public static String NDG_TITULO_MENSAJE_ERROR = "Belcorp";
  public static String NDG_OPERACION_OK_NO_DOCUMENTADO = "Mensaje no documentado";
  public static String NDG_TITULO_MENSAJE_OK = "Belcorp";
  public static int NDG_CODIGO_MENSAJE_OPERACION_OK = 1;

  public static String NDG_USU_ID = "ID_USU";
  public static String NDG_USU_PASSWORD = "CLAVE";
  public static String NDG_USU_ADMINISTRADOR = "IND_ADMIN"; 
  public static String NDG_USU_NDG = "IND_NDG";
  public static String NDG_USU_USUARIOSICC = "IND_USU_SICC";

  public static String NDG_PERIO_PAIS              = "OID_PAIS";
  public static String NDG_PERIO_PERIODO_INICIAL   = "PERI_INIC";
  public static String NDG_PERIODO_FINAL           = "PERI_FINA";
  public static String NDG_PERIO_FECHA_FACTURACION = "FEC_FAC";

  public static String NDG_CLIEN_PAIS              = "OID_PAIS";
  public static String NDG_CLIEN_OID_CLIEN         = "COD_CLIE";
  public static String NDG_CLIEN_APE1              = "VAL_APE1";
  public static String NDG_CLIEN_APE2              = "VAL_APE2";
  public static String NDG_CLIEN_NOM1              = "VAL_NOM1";
  public static String NDG_CLIEN_NOM2              = "VAL_NOM2";
  public static String NDG_CLIEN_SUBG_VENT         = "COD_SUBG_VENT";
  public static String NDG_CLIEN_REGION            = "COD_REGI";
  public static String NDG_CLIEN_ZONA              = "COD_ZONA";
  public static String NDG_CLIEN_TERRITORIO        = "COD_TERR"; 

  /**
   * @Autor: Cortaberria
   * @Fecha: 12/11/04
   * Cambio OID_PAIS y OID_PERI a  COD_PAIS y COD_PERI respectivamente.
   */
  public static String NDG_CODIG_VENT_PAIS         = "COD_PAIS";
  public static String NDG_CODIG_VENT_PERIODO      = "COD_PERI";
  public static String NDG_CODIG_VENT_CODIGO_VENTA = "VAL_CODI_VENT";
   
  //Flags
  public static int NDG_INSERTAR = 0;
  public static int NDG_MODIFICAR = 1;
  public static int NDG_TIPO_DESPACHO_NORMAL = 1;

  public static String NDG_ESTADO_DIGITADO = "DIGI";
  public static String NDG_ESTADO_ERRONEO = "ERRO";

  //Procesos
  public static String NDG_PROCESO_DIGITACION_INICIAL = "P115";
  public static String NDG_PROCESO_REGISTRO_SOLICITUDES = "P110";
  public static String NDG_PROCESO_VERIFICAR_SOLICITUD = "P120"; 
  
  public static String NDG_GRUPO_PROCESOS_1 = "GP1";

  public static String PED_LOTE_NUM_LOTE = "NUM_LOTE";
  public static String PED_LOTE_FEC_REGI = "FEC_REGI";
  public static String PED_LOTE_PERIODO = "PERIODO";
  public static String PED_LOTE_COD_PAIS = "COD_PAIS";
  public static String PED_LOTE_MARCA = "COD_MARCA";
  public static String PED_LOTE_CANAL = "COD_CANAL";   
  public static String PED_LOTE_TIPO_SOLICITUD = "TIPO_SOLIC";
  
  public static String PED_REGIS_SOLIC_NUM_REGI = "NUM_REGI";
  public static String PED_REGIS_SOLIC_NUM_DIGI = "NUM_DIGI";
  public static String PED_REGIS_SOLIC_CLIENTE = "COD_CLIE";
  public static String PED_REGIS_SOLIC_LOTE = "NUM_LOTE";
  public static String PED_REGIS_SOLIC_PAIS = "COD_PAIS";
  public static String PED_TIPO_SOLICITUD = "TIPO_SOLIC";

  //Codigos de Interfaces
  public static String NDG_INTERFAZ_LOTE          = "NDG-6L";
  public static String NDG_INTERFAZ_REGISTRO      = "NDG-6R";
  public static String NDG_INTERFAZ_ORDEN_COMPRA  = "NDG-5C";
  public static String NDG_INTERFAZ_POSICION      = "NDG-5P";
  
  public static String NDG_INTERFAZ_USUARIO         = "NDG-7";
  public static String NDG_INTERFAZ_PERIODO         = "NDG-4";
  public static String NDG_INTERFAZ_CONSULTORAS     = "NDG-1";
  public static String NDG_INTERFAZ_MATRIZ_PRECIOS  = "NDG-2";
 
}

