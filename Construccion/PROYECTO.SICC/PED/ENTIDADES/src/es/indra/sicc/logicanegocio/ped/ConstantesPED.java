/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.logicanegocio.ped;

public class ConstantesPED  {
  public ConstantesPED() {
  }


  public static final Long GP1 = new Long(1);
  public static final Long GP2 = new Long(2);
  public static final Long GP3 = new Long(3);
  public static final Long GP4 = new Long(4);
  public static final Long GP5 = new Long(5);
  public static final String SOCIEDAD_DEFECTO = "SociedadPorDefecto"; 
  //public static final Long SUBACCESO_DEFECTO = new Long(52); inc BELC300014730
  public static final String SUBACCESO_DEFECTO = "SubaccesoPorDefecto";
  public static final Long MODULO_PEDIDOS = new Long(1);
  public static final Long MODULO_RECLAMOS = new Long(15);
  public static final Long ESTADO_SOLICITUD_VALIDADO = new Long(1);
  public static final Long ESTADO_SOLICITUD_RECHAZADO = new Long(2);
  public static final Long ESTADO_SOLICITUD_BLOQUEADO = new Long(3);
  public static final Long ESTADO_SOLICITUD_ANULADO = new Long(4);
  public static final Long ESTADO_SOLICITUD_LIBERADO = new Long(5);
  public static final Long ESTADO_SOLICITUD_ERRONEO = new Long(6);
  public static final Long ESTADO_POSICION_RECUPERACION = new Long(1);
  public static final Long ESTADO_POSICION_ANULADO = new Long(2);
  public static final Long ESTADO_POSICION_BLOQUEADO = new Long(3);
  public static final Long ESTADO_POSICION_CORRECTO = new Long(4);
  public static final Long ESTADO_POSICION_NO_ATENDIDA = new Long(5);
  public static final Long TIPO_DOCUMENTO_PEDIDO = new Long(1);
  public static final Long TIPO_DOCUMENTO_CONSOLIDADO = new Long(2);
  public static final Long TIPO_DOCUMENTO_LISTA_PICADO = new Long(3);
  public static final Long TIPO_DOCUMENTO_ORDEN_TRANSPORTE = new Long(4);
  public static final String COD_PROCESO_NULO = "0000";
  public static final Long HITO_01 = new Long(1);
  public static final Long HITO_02 = new Long(2);
  public static final Long HITO_04 = new Long(4);
  public static final Long HITO_05 = new Long(5);
  public static final Long HITO_10 = new Long(10);
  public static final Long HITO_15 = new Long(15);
  public static final Long HITO_20 = new Long(20);
  public static final Long HITO_25 = new Long(25);
  public static final Long HITO_30 = new Long(30);
  public static final String FORMULARIO_REGISTRO = "Registro de Solicitudes";
  public static final String PROCESO_VALIDAR_FLETE = "P265";
  public static final Long TIPO_POSICION_ALTERNATIVA = new Long(5);
  public static final String OPERACION_PED001 = "PED001";
  public static final Integer SI = new Integer(1); //Incid. 7064
  public static final Integer NO = new Integer(0); //Incid. 7064
  public static final Long SUBTIPO_POSICION_ALTERNATIVA = new Long (7);
  public static final long CONSTANTE_DIA = 86400000; 
  public static final String PED_SOLI_CABE = "PED_SOLIC_CABEC";
  public static final String PED_SOLI_POSIC = "PED_SOLIC_POSIC";
  public static final Long TIPO_POSICION_CUADRE_OFERTAS = new Long(4);
  public static final Long SUBTIPO_POSICION_CUADRE_OFERTAS = new Long(4);
  public static final Long OID_REVISION_LINEA = new Long(1);
  public static final Long OID_REVISION_CAMPO = new Long(2);
  public static final Long OID_REVISION_AMBAS = new Long(3);
  public static final Long INFORMACION_BASICA_POSICION = new Long(1);
  public static final Long INFORMACION_PRODUCTOS_POSICION = new Long(2);
  public static final Long INFORMACION_CANTIDADES_POSICION = new Long(3);
  public static final Long INFORMACION_ECONOMICA_POSICION = new Long(4);
  public static final String PED_090_OBSERV = "Recuperación de faltantes. Pedido de Servicio";
  public static final String MENSAJE_PED03 = "PED03";
  public static final String NUEVA_POSICION = "Nueva posición";
  public static final String POSICION_ELIMINADA = "Posición eliminada";
  public static final String CV_ERROR = "Error en código venta";
  public static final String UD_ERROR = "Error en número unidades";
  public static final String CORRECTO = "Correcto";
  public static final Long ACCESO_DEFECTO = new Long(51);
  public static final Long CANAL_DEFECTO = new Long(50);
  
  public static final String CV = "V";
  public static final String PRODUCTO = "P";
  public static final String FLETE_ZONA = "Z";
  public static final String FLETE_UBIGEO = "U";
  public static final Long HITO_31 = new Long(31);
  public static final Long HITO_21 = new Long(21);
  public static final Long TIPO_SOLICITUD_ORDEN_COMPRA = new Long(8);
  public static final String COD_TIPO_SOLICITUD_ORDEN_COMPRA = "O1";
  
  //inc.: 23213
  public static final String COD_POSICION_ANULADA = "AN";
  
  // vbongiov -- 16/08/2006
  public static final Long CLASE_SOL_I1 = new Long(3);
  public static final Long CLASE_SOL_C1 = new Long(4);
  
  // SICC-GCC-FAC-002 - dmorello, 17/10/2006
  public static final String INDICADOR_IMPUESTO_PERCEPCION = "PER";
  
  // Agregado por HRCS - Fecha 02/05/2007 - Cambio Sicc20070217
  public static final String CODIGO_ESTRAT_INDIVIDUAL_MONTO_MINIMO = "018";
  public static final String MENSAJE_PED09 = "PED09";
  public static final String CODIGO_TIPO_POSICION_MONTO_MINIMO = "MM";
  public static final String CODIGO_SUBTIPO_POSICION_MONTO_MINIMO = "MM";
  
  //enozigli 05/06/09 monto maximo
    public static final Long ESTADO_ANULADO_POR_MONTO_MAXIMO = new Long(21);
    
    public static final String TIPO_SEGMENTACION_PROPERTIES = "0";
    public static final String TIPO_SEGMENTACION_MANUAL = "1";
    public static final String TIPO_SEGMENTACION_AUTOMATICO = "2";
    
}