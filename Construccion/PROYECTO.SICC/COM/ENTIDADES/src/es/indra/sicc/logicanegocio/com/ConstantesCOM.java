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
 */
 
package es.indra.sicc.logicanegocio.com;

public class ConstantesCOM {    
    public static final Long ESTADO_ACTIVO = new Long(1); 
    public static final Long ESTADO_ELIMINADO = new Long(2);
    
    public static final String COM_SI = "SI";
    public static final String COM_NO = "NO";
    
    public static final Long COMISION_SOBRE_VENTA_TOTAL = new Long(1);    
    public static final Long COMISION_SOBRE_INCREMENTO = new Long(2);
    
    public static final Long ESTADO_COMISION_EN_CREACION = new Long(1);    
    public static final Long ESTADO_COMISION_ACTIVA = new Long(2);  
    public static final Long ESTADO_COMISION_SOLICITUD_CAMBIO = new Long(3);    
    public static final Long ESTADO_COMISION_SOLICITUD_ACEPTADA = new Long(4);    
    public static final Long ESTADO_COMISION_SOLICITUD_RECHAZADA = new Long(5);   
    public static final Long ESTADO_COMISION_CONFIRMACION_CAMBIOS = new Long(6);       
    public static final Long ESTADO_COMISION_CAMBIOS_RECHAZADOS = new Long(7);    
    public static final Long ESTADO_COMISION_ELIMINADA = new Long(8);   
    public static final Long ESTADO_COMISION_CALCULADA_Y_PENDIENTE = new Long(1);
    
    public static final Long INSERTAR_POR_CODIGO_PRODUCTO = new Long(1);    
    public static final Long TIPO_INSERCION_PRODUCTO = new Long(1);        
    
    public static final Long MODULO_GENERADOR_COMISION = new Long(1);    
    public static final Long MODULO_GENERADOR_INCENTIVO = new Long(2);    
    
    public static final Long ESTADO_COMISION_CLIENTE_CALCULADA = new Long(1);    
    public static final Long ESTADO_COMISION_CLIENTE_PAGADA = new Long(2);    
    
    public static final Long FORMA_PAGO_SIN_PLANILLA = new Long(1);    
    public static final Long FORMA_PAGO_CON_PLANILLA = new Long(2);        
    
    public static final Long OID_TIPO_PRODUCTO_INCLUSION = new Long(1);
    public static final Long OID_TIPO_PRODUCTO_EXCLUSION = new Long(2);    
    
    public static final Long TIPO_PARTICIPANTE_FRONTERA = new Long(1);
    public static final Long TIPO_PARTICIPANTE_PROVINCIA = new Long(2);
    public static final Long TIPO_PARTICIPANTE_CAPITAL = new Long(3);
    
    public static final Long TIPO_COMISION_VENTAS = new Long(1);
    public static final Long TIPO_COMISION_COBRANZA = new Long(2);
    
    public static final String COMISION_COBRANZAS = new String("C");
    public static final String COMISION_VENTAS = new String("V");
    //public static final String COMPARATIVO_FILE = new String("F");
    //public static final String COMPARATIVO_HISTORICO = new String("H");
    public static final String PRODUCTO_INCLUIDO = new String("I");
    public static final String PRODUCTO_EXCLUIDO = new String("E");
    
    public static final Long COMPARATIVO_HISTORICO = new Long(1);
    public static final Long COMPARATIVO_FILE = new Long(2);
    
    public static final Long GERENTE_SIN_PLANILLA = new Long(1);
    public static final Long GERENTE_CON_PLANILLA = new Long(2);
	    
    // constante agregada por el cambio de diseño de acuerdo de inc.  BELC300014335
    public static final String ELIMINADO = new String("Eliminado");
    
    public static final Long VENTA_NETA = new Long(1);
    public static final Long VENTA_FACTURA = new Long(2);
    public static final Long VENTA_CATALOGO = new Long(3);
    
    
    //constante agregada por incidencia DBLG500000890
    public static final String CODIGO_CLASIFICACION_GERENTE = new String("G");
    
}
