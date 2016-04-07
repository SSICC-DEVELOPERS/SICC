package es.indra.sicc.comunapplet;

public class ConstantesApplet {
  public static final String USER_NAME = "userName";

  public static final String CV = "V";
  public static final String PRODUCTO = "P";
  public static final String FLETE_ZONA = "Z";
  public static final String FLETE_UBIGEO = "U";

  //Constante perteneciente a SEG
  public static final Long [] OIDS_ACCESO_CALLCENTER = {new Long(4)};
  public static final String ACCESO_BELCENTER = "BL";
  public static final String ACCESO_CALLCENTER = "CL";

  //Errores
  public static final int ERROR_CARGA_INICIAL = 10;
  public static final int ERROR_AL_REINICIAR_CAMPOS = 11;
  public static final int PED_0016 = 12;
  public static final int ERROR_FALTAN_DATOS_OBLIGATORIOS = 13;
  public static final int ERROR_DE_SERVIDOR = 14;
  public static final int ERROR_DATOS_INVALIDOS = 15;
  public static final int ERROR_GENERACION_POSICION = 16;
  public static final int UIPED031 = 17;
  public static final int ERROR_AL_GUARDAR_SOLICITUD = 18;
  public final static int ERROR_FALTA_PARAMETRO_OBLIGATORIO_PAIS          = 19;
  public final static int ERROR_FALTA_PARAMETRO_OBLIGATORIO_FECHA_SISTEMA = 20;
  public final static int ERROR_FALTA_COMPLETAR_CAMPO_OBLIGATORIO         = 21;
  public final static int ERROR_CODIGO_VENTA_NO_EXISTE_O_NO_DIGITABLE     = 22;
  public final static int ERROR_POSICION_INVALIDA     = 23;
  public static final int NO_EXISTEN_PRODUCTOS_ALTERNATIVOS = 24;
  public static final int FECHA_INVALIDA = 25;
  public static final int NUMERO_INVALIDO = 26;
  public static final int ERROR_FALTA_CODIGO_VENTA_PRODUCT = 27;
  public static final int ERROR_FALTA_PARAMETRO_OBLIGATORIO_URL = 28;
  public static final int ERROR_AL_OBTENER_SOLICITUD_COBRO = 29;
  public static final int ERROR_FALTA_PARAMETRO_OBLIGATORIO_IDIOMA = 38;
  public static final int BEL_0017 = 43;
  
  //Mensajes
  public static final int DATOS_CLIENTE_NO_EXISTENTES = 30;
  public static final int PED_0013 = 40;
  public static final int PED_0014 = 41;
  public static final int ALMACEN_NO_PARAMETRIZADO = 32;
  public static final int GEN_UIGEN0004 = 33;//Debe seleccionar un elemento
  public static final int UIPED034 = 34;
  public static final int UIPED033 = 35;
  public static final int UIPED041 = 44 ; // Producto sin existencias
  public static final int PED_040 = 36; //El cliente no tiene parametrizado Fletes
  public static final int NO_EXISTEN_DATOS = 37;
  public static final int FALTA_ANADIR_CLIENTES = 39;
  public static final int INFORME_APROBADO = 31;
  public static final int ERROR_FALTA_CAMPO_OBLIGATORIO = 42;
    
  
  //Titulos mensajes
  public static final int TITULO_CONFIRMACION = 50;
  public static final int TITULO_ERROR = 51;
  
  //Mensajes para dialogos
  public static final int MSG_CONFIRMACION = 70;
  
  //Campos obligatorios en DATOS COBRO
  public static final int CAMPO_MEDIO_PAGO_ES_OBLIGATORIO = 71;
  public static final int CAMPO_IMPORTE_ES_OBLIGATORIO = 72;
  public static final int CAMPO_IMPORTE_DIVISA_ES_OBLIGATORIO = 73;
  public static final int CAMPO_BANCO_ES_OBLIGATORIO = 74;
  public static final int CAMPO_N_CHEQUE_ES_OBLIGATORIO = 75;
  public static final int CAMPO_TIPO_TARJETA_ES_OBLIGATORIO = 76;
  public static final int CAMPO_N_TARJETA_ES_OBLIGATORIO = 77;
  public static final int CAMPO_N_VALE_COMPRA_ES_OBLIGATORIO = 78;
  public static final int CAMPO_N_NOTA_CREDITO_ES_OBLIGATORIO = 79;

  public static final int BEL_0014 = 80;
  
}