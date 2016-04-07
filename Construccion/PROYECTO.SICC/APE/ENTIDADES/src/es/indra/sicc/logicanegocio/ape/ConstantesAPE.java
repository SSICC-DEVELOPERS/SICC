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
 
package es.indra.sicc.logicanegocio.ape;

public class ConstantesAPE {
    public static final String COD_PICADO_MANUAL = "02";
    public static final String COD_PICADO_PTL = "01";
    public static final String COD_TIPO_CAJA_GRANDE = "01";
    public static final String COD_TIPO_CAJA_PEQUENIA = "02";
    public static final Long TIPO_CAJA_GRANDE = new Long(1);
    public static final Long TIPO_CAJA_PEQUENIA = new Long(2);
    public static final Long COD_MAPA_ORDEN  = new Long(-1);      
    public static final Long OID_PROCEDENCIA_MANUAL = new Long(1);  
    public static final Long OID_PROCEDENCIA_ESTIMADO = new Long(2);
    public static final Long OID_PROCEDENCIA_BALANCEO = new Long(3);   
    public static final Long OID_PROCEDENCIA_PREASIGNACION = new Long(4);       
    public static final Integer TRUE = new Integer(1);
    public static final Integer FALSE = new Integer(0);  
    public static final String CONFIGURACION_CD = "CD";
    public static final String LINEA_ARMADO = "LA";
    public static final String MAPA_ZONA = "MZ";
    public static final String ORDEN_ANAQUEL = "OA";    
    public static final String ESTADO_ANULADA = "A";
    public static final String ESTADO_REIMPRESA = "R";
    public static final String ESTADO_IMPRESA = "I";    
    public static final Character IMPRESION_SI = new Character('S');
    public static final Character IMPRESION_NO = new Character('N');    
    public static final Long SIN_ORDEN = new Long(0);    
    public static final Long ORDEN_POR_ANAQUEL = new Long(1);
    public static final Long ORDEN_POR_PRODUCTO = new Long(2);    
    public static final String ESTADO_PREASIGNADO = "P";    
    public static final String FUENTE_ESTIMADO = "E";
    public static final String FUENTE_FACT_PROY = "F";    
    public static final String COD_PREASIGNACION = "P";
    public static final String COD_PROCEDENCIA_MANUAL = "M";
    public static final String COD_BALANCEO = "B";        
    public static final String ACTIVO_FACTURACION_S = "S";
    public static final String ACTIVO_FACTURACION_N = "N";    
    public static final String MAGNITUD_VOLUMEN = "VO";
    public static final String MAGNITUD_LONGITUD = "LO";        
    public static final Long OID_ORDENACION_ASCENDENTE = new Long(1);
    public static final Long OID_ORDENACION_DESCENDENTE = new Long(2);    
    public static final Integer MAX_BAHIAS_SUBLINEA = new Integer(50);
    public static final Integer MAX_NIVELES_SUBLINEA = new Integer(26);
    public static final Integer MAX_COLUMNAS_SUBLINEA = new Integer(9);    
    public static final Long ETIQUETADO_MANUAL = new Long(1);
    public static final Long ETIQUETADO_AUTOMATICO = new Long(2);    
    public static final Long SUBACCESO_DEFECTO = new Long(888);    
    public static final String FUERA_PEDIDO_ZONA    = "Z";
    public static final String FUERA_PEDIDO_SECCION = "S";
    public static final String COD_SGTE_ASIGNACION = "S";
    public static final Long OID_SISTEMA_PICADO_PTL = new Long(1);
    public static final Long OID_SISTEMA_PICADO_MANUAL = new Long(2);
    public static final Long OID_CUBICAJE_VOLUMEN = new Long(1);    
    
    public static final Long OID_ESTADO_PEDIDO_INDUCIDO = new Long(1);
    public static final Long OID_ESTADO_PEDIDO_EMBALADO = new Long(2);
    public static final Long OID_ESTADO_PEDIDO_CHEQUEADO = new Long(3);
    public static final Long OID_ESTADO_PEDIDO_INCONSISTENTE = new Long(4);
    public static final Long OID_ESTADO_PEDIDO_REVISADO = new Long(5);
    public static final Long OID_ESTADO_PEDIDO_LEVANTAMIENTO = new Long(6);
    public static final Long OID_ESTADO_PEDIDO_TERMINADO = new Long(7);
    
    // vbongiov -- 28/05/2007 -- Inc BELC400000443
    public static final Long OID_ESTADO_EMBALADO = new Long(2);
    public static final Long OID_ESTADO_TERMINADO = new Long(7);
    
    public static final Long OID_ERROR_FALTANTE_FACTURADO = new Long(1);
    public static final Long OID_ERROR_FALTANTE_CANTIDAD = new Long(2);
    public static final Long OID_ERROR_SOBRANTE_CANTIDAD = new Long(3);
    public static final Long OID_ERROR_SOBRANTE_NO_FACTURADO = new Long(4);
    
    public static final String COD_ERROR_FALTANTE_FACTURADO = "FF";
    public static final String COD_ERROR_FALTANTE_CANTIDAD = "FC";
    public static final String COD_ERROR_SOBRANTE_CANTIDAD = "SC";
    public static final String COD_ERROR_SOBRANTE_NO_FACTURADO = "SF";
    
    public static final Long OID_ESTADO_CHEQUEADO = new Long(3);
    public static final Long OID_ESTADO_INCONSISTENTE = new Long(4);
    
    public static final String CHEQUEO_EVALUACION_RECLAMOS = "R";
    public static final String CHEQUEO_CAPTURA_MANUAL = "M";
    public static final String CHEQUEO_PRIMER_PEDIDO = "P";

    public static final Long TECNOLOGIA_IMPRESORA =  new Long(3);
    
    public static final String ERROR_LEVANTAR_CHEQUEO = "ELC-1";
    
    public static final String ERROR_L_CHEQ_FECHA = "fecha";
    public static final String ERROR_L_CHEQ_NUMSOLI = "numsoli";            
    public static final String ERROR_L_CHEQ_NUMCAJA = "numcaja";
    
    public static final String SOBRANTE_FACTURA = "SF";   
    
    // vbongiov -- Cambio APE-012 -- 15/05/2008
    public static final String TIPO_REVISION = "L"; 
    public static final String CHEQUEO_CONFORME = "OK"; 
    
    // vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
    public static final Long ORDEN_VISU_CHEQ_VOLUMEN =  new Long(1);
    public static final Long ORDEN_VISU_CHEQ_NRO_UNIDADES =  new Long(2);
    public static final Long ORDEN_VISU_CHEQ_CLAS_PROD =  new Long(3);
    
    public static final String FUERA = "F"; 
    
    // sapaza -- Cambios para WCS y MUO -- 22/09/2010
    public static final Long ORDEN_POR_SUBLINEA_PRODUCTO = new Long(3);    
    public static final Long ORDEN_POR_SUBLINEA_ANAQUEL = new Long(4);
    public static final String COD_ORDEN_POR_ANAQUEL = "A";
    public static final String COD_ORDEN_POR_PRODUCTO = "P";    
    public static final String COD_ORDEN_POR_SUBLINEA_ANAQUEL = "Q";
    public static final String COD_ORDEN_POR_SUBLINEA_PRODUCTO = "R";    

    public static final String COD_ORDENACION_ASCENDENTE = "A";
    public static final String COD_ORDENACION_DESCENDENTE = "D";    

    public static final String COD_PICADO_AFRAME = "03";

}