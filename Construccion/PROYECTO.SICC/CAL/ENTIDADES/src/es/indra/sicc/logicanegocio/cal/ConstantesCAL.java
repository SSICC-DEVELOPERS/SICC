/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.cal;

public class ConstantesCAL  {
  public static final Long NO_PROCESADO = new Long(1);
  public static final Long PROCESADO = new Long(2);
  public static final Long OID_LLAMADA_DIRECTA = new Long(1);
  public static final Long OID_CONSULTA_INTERNA = new Long(2);
  public static final String CAL002 = "CAL002";
  public static final Long OID_MOTIVO_INFO_GENERAL = new Long(30);
  //OID_ATRIBUTO_ESTADO_NORMAL_REGISTRADO eliminado por incidencia 12324
  public static final Integer ACTIVO = new Integer(1);
  public static final Integer INACTIVO = new Integer(0);
  public static final Long OID_TIPO_ESTADO_CONTACTO_REGISTRADO = new Long(1);
  public static final Long OID_TIPO_ESTADO_CONTACTO_EN_PROCESO = new Long(2);
  public static final Long OID_TIPO_ESTADO_CONTACTO_CERRADO = new Long(3);
  public static final String OBSERV_BLOQUEO_ADMINISTRATIVO = "Bloqueo administrativo (Call Center)";
  public static final String COD_PROCESO_COMPRA = "LPRegistroOnline";
  public static final String COD_PROCESO_INGRESAR_RECLAMO = "LPMantenimientoReclamos";
  public static final String COD_PROCESO_CONSULTAR_MENSAJES = "LPConsultarMensajes";
  public static final String OPCION_MENU_CONSULTAR_MENSAJES = "Consulta Mensajes por Consultora";
  public static final String COD_ATRIBUTO_NORMAL = "01"; //añadido por incidencia 12324 
  //Dato necesario para que no se produzca un error cuando invoca a la LPBusquedaCliente 
  //desde  LPGestionarContactos
  public static final String COD_PROCESO_CONSULTAR_CLIENTE = "LPBusquedaCliente";
}