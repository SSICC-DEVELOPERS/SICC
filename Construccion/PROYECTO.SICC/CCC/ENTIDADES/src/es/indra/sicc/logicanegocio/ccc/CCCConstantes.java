/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ccc;

public class CCCConstantes  {

	public static final String MOVIMIENTO_BANCARIO_PENDIENTE = "P";
	public static final String MOVIMIENTO_BANCARIO_TRANSMITIDO = "T";
	public static final String MOVIMIENTO_BANCARIO_INCORRECTO = "I"; 
	public static final String MARCA_ENTRADA = "E";
	public static final String MARCA_SALIDA = "S";
	public static final String MOVIMIENTO_BANCARIO_APLICADO = "A";
	public static final String MOVIMIENTO_BANCARIO_PROCESADO = "P"; 
	public static final String CANCELACION_CUOTAS = "1";
	public static final String APLICACION_COBROS = "2";
	public static final String GENERACION_VENCIMIENTOS = "4";
	public static final String CONCEPTOS_GASTOS_ABONOS = "3";
	public static final String BLOQUEO_FINANCIERO = "5";
	public static final String PROCESO_GESTION_CHEQUES = "CCC004";
	public static final String PROCESO_PROVISION_DEPURACION = "CCC006";
	public static final String RECLAMO_SITUACION_SOLICITADO = "1";
	public static final String RECLAMO_SITUACION_EN_PROCESO = "2";
	public static final String RECLAMO_SITUACION_RESUELTO = "3";
	public static final String RECLAMO_SITUACION_RECHAZADO = "4"; 
	public static final String INCOBRABLE_SITUACION_ELABORACION = "1";
	public static final String INCOBRABLE_SITUACION_SOLICITADO = "2";
	public static final String INCOBRABLE_SITUACION_APROBADO = "3";	
	public static final String INCOBRABLE_SITUACION_RECHAZADO ="4";	
	public static final String PROCESO_ACTUALIZ_AUT_CANCELACION_DEUDA = "CCC002";
 	public static final String PROCESO_MOVIMIENTO_MANUAL = "TES002";
	public static final String HORARIO_NORMAL = "N";
	public static final String HORARIO_ADICIONAL = "A";
	public static final String SITUACION_CUPON_TRAMITE = "T";
	public static final String SITUACION_CUPON_DEPURACION = "D";
	public static final String SITUACION_CUPON_CONCILIADO = "C";
	public static final String SUBPROCESO_DESCUENTO = "1";
	public static final String SUBPROCESO_RECARGO = "2";
	public static final String TIPOERROR_CLIENTE_NO_EXISTE = "01";
	public static final String TIPOERROR_FECFACTURA_POSTERIORPAGO = "02";
	public static final String TIPOERROR_NUMFAC_NOEXISTE_ANULADO = "03";
	public static final String TIPOERROR_IMPORTE_SUPERIOR_DEUDA = "04";
	public static final String TIPOERROR_NO_ERROR = "00";
	public static final Long MODULO_CCC = new Long(23); //incidencia BELC300009492
	public static final Integer SITUACION_DTO_RECARGO_APROBADO = new Integer(1);
	public static final String PROCESO_DTO_RECARGO_AUTO = "CCC005";
	public static final String PROCESO_CON006 = "CON006";
    public static final String CODIGO_PROCESO_CON005 = "CON005";
   public static final String PROCESO_MOVIMIENTO_AUTOMATICO = "TES001";
   public static final String PROCESO_CON001 = "CON001";
   public static final Long SUBPROCESO_CONSULTA_DEUDA = new Long(1);
   
   public static final String CODIGO_CUENTA_DIRECTA = "D"; // incidencia BELC300013454
   public static final String CODIGO_CUENTA_BANCO = "B"; // incidencia BELC300013454
   public static final String CODIGO_CUENTA_PUENTE_BANCO = "P"; // incidencia BELC300013454
   public static final String CODIGO_CUENTA_ABONO_CARGO = "T"; // incidencia BELC300013454
   public static final String CODIGO_CUENTA_CUOTA_ANTERIOR = "C"; // incidencia BELC300013454
   public static final String CODIGO_CUENTA_CUOTA_NUEVA = "N"; // incidencia BELC300013454
   
   public static final String COD_DEBE = "D"; // incidencia BELC300013487
   public static final String COD_HABER = "H"; // incidencia BELC300013487
   
   public static final Long OID_SUBPROCESO_FACTURACION = new Long(1); // incidencia BELC300013631
   public static final String OFICINA_BELCENTER = "Belcenter"; // incidencia BELC300013631
   
   
   public static final String TIPO_ABONO_CARGO_DIRECTO = "C";
   public static final String TIPO_ABONO_AJUSTE = "A";
   public static final String TIPO_ABONO_NOTA_CREDITO = "N";
   

   public static final String DEUDA_INCOBRABLE = "I";
   public static final String DEUDA_COBRABLE = "N";
   //incidencia 21792
   public static final String RECAUDO_MANUAL_NO_APLICADO = "TES001";
   
   //inc.: BELC300022992
   public static final String APLIC_AUTOMATICA_MOV_BANC = "TES002";

   public static final String TESP01_PERCEP_RECAUDOS_BANCARIOS = "TESP01";
   public static final String CCCEN1_PAGOS_EN_EXCESO_NEGATIVO = "CCCEN1";
   public static final String CCCP07_PERCEP_DECUENTOS_A_PERSONAL = "CCCP07";
   public static final String CCCP11_PERCEP_ABONOS_CANAL_INTERNET = "CCCP11";
   public static final String TIPO_TRANSACCION_REASIGNACION_PAGO = "RP";//cambio col_ccc_03 (gacevedo)
   public static final String PROCESO_REASIGNACION_PAGOS_ENTRE_CONSULTORAS = "TES005";//cambio col_ccc_03 (gacevedo)
   
}