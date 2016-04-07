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

package es.indra.sicc.logicanegocio.fac;

public class ConstantesFAC  {

	public static final String COD_GP5 = "GP5"; 
	public static final String COD_SECUENCIA_MONITOR = "M"; 
	public static final String COD_SECUENCIA_TRANSPORTE = "T"; 
	public static final String RUV_ESTADO_ACTIVO = "A"; 
	//public static final Long MODULO_ORIGEN_FAC = new Long(22); //BELC30009502, se elimina por incidencia BELC300013490
	public static final String COD_MENSAJE_01 = "FAC01"; 
	public static final String LISTA_CONSULTORAS_N = "N"; 
	public static final String ESTADO_RUV_ACTIVO = "A"; 
	public static final String COD_BALANCEO_COLOMBIA = "C"; 
	public static final String COD_BALANCEO_PERU = "P";
	public static final String COD_PROC_BALANCEO_AREA_CHEQUEO = "P505"; 
	public static final String COD_PROC_GENERAR_MARCAS_CHEQUEO = "P508"; 
	public static final Long  OID_IND_ESTADISTICABLE = new Long(69); //BELC300009006
	public static final String COD_OP_SOLICITUD_CONSOLIDADO_PEDIDO = "PED001";//Incidencia BELC300008715
	public static final String COD_ESTADO_SOLICITUD_OK = "OK"; //Incidencia BELC300008725
	public static final String COD_OP_ACTUALIZAR_STOCK_FAC = "FAC001"; //Incidencia BELC300009066
	public static final String COD_PROC_NULO = "P500"; //Incidencia BELC300008725

	// añadidas por el ultimo diseño 
	public static final String COD_PROC_GENERAR_REGISTRO_CC = "P520" ;
	public static final String COD_PROC_GENERAR_DOC_CONTABLE = "P510"; 
	public static final String IND_CALCULO_DOC_CONTABLE = "D"; 
	public static final String IND_CALCULO_SOLICITUD = "C"; 
	public static final String COD_GP4 = "GP4"; 
	//public static final String COD_MOD_ORIGEN_RECLAMOS = "15"; se elimina por incidencia BELC300013490
	//public static final String COD_MODULO_PEDIDOS = "01"; se elimina por incidencia BELC300013490
	//public static final String COD_OP_FAC075 = "FAC075" ; se elimina por incidencia BELC300013573
	public static final String COD_PROC_GENERAR_RUV = "P515";

	public static final String TIPO_CIERRE_ZONA = "Z"; 
	public static final String TIPO_CIERRE_REGION = "R" ;
	public static final String TIPO_CIERRE_PERIODO = "P";
	public static final Character ID_BOLETA = new Character('B'); 
	public static final Character ID_FACTURA = new Character('F');

	public static final String PROCESO_CIERRE_OK = "OK"; 
	public static final String PROCESO_CIERRE_ERROR = "KO";

    public static final Long OID_GUIA_REMISION = new Long(8);//Incidencia BELC300013359
    
	public static final Boolean IND_INACTIVO = Boolean.FALSE; //Incidencia BELC300018507
    
    public static final String CODIGO_IMPUESTO_EXP = "EXP"; //Cambio Sicc20070188
    public static final Long INDICADOR_ACTIVO = new Long(1);
    public static final Long INDICADOR_DESACTIVO = new Long(0);
    
    /* BELC400000697 - dmorello, 31/08/2007 */
    public static final String MODALIDAD_DISTRIBUCION_APE = "A";    
    
    // dmorello, 22/11/2007
    public static final String COD_PROC_CERRAR_ARMADO = "P523";
}