/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.intsys;


public class ConstantesPTL {
    public static final String PTL1_IND_CAB = "SO";
    public static final String PTL1_NRO_FACT = "1";
    public static final String PTL1_IND_CHEQUEO = "31";
    public static final String PTL1_IND_DET = "SS";
    public static final String PTL1_UNID_ATEN = "8";
    public static final String PTL1_DESC_PROD = "21";
    public static final String PTL1_COD_PROD = "30";
    
    // Interfaz PTL-3
    public static final Long PTL3_CANT_REG_CAB_CAJA = new Long(9);
    public static final Long PTL3_CANT_REG_DET_CAJA = new Long(7);
    // - Prefijos Cabecera de Factura
    public static final String PTL3_CAB_FAC = "SB";
    public static final String PTL3_NRO_FAC = "1";
    // - Prefijos Detalle de Caja
    public static final String PTL3_CAB_CAJA = "SO";
    public static final String PTL3_NRO_CAJA_PTL = "1";
    public static final String PTL3_IND_CHEQUEO = "31";
    public static final String PTL3_OPER_INT_FAC = "32";
    public static final String PTL3_OPER_CHEQ_FAC = "33";
    public static final String PTL3_IND_CAJAS_ACEP = "34";
    public static final String PTL3_NRO_ORIG_CAJA_FACTURA = "35";
    public static final String PTL3_NRO_ACTUA_CAJA_FACTURA = "36";
    public static final String PTL3_NRO_CAJA = "37";
    public static final String PTL3_TIPO_CAJA = "38";
    // - Prefijos Detalle de Caja-Producto
    public static final String PTL3_DET_CAJA = "SS";
    public static final String PTL3_ANAQUEL = "7";
    public static final String PTL3_CANT_REQ_PICAR = "8";
    public static final String PTL3_CANT_ACTUAL_PICADA = "9";
    public static final String PTL3_NOM_PICADOR = "16";
    public static final String PTL3_DESC_PROD = "21";
    public static final String PTL3_IND_CAMBIO = "29";
    public static final String PTL3_COD_PROD = "30";
    
    public ConstantesPTL() {  }
    
}