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

package es.indra.sicc.logicanegocio.rec;

public class ConstantesREC {

    public static final Long	ASUME_CLIENTE 				 = new Long(1); 
    public static final Long	ASUME_SEGURO 				 = new Long(2); 
    public static final Long	ASUME_BELCORP 				 = new Long(3); 
    public static final Long	ESTADO_OPERACION_INGRESADO 	 = new Long(1); 
    public static final Long	ESTADO_OPERACION_ENVIADO 	 = new Long(2); 
    public static final Long	ESTADO_OPERACION_PARCIAL 	 = new Long(3); 
    public static final Long	ESTADO_OPERACION_BLOQUEO 	 = new Long(4); 
    public static final Long	ESTADO_OPERACION_FACTURADO 	 = new Long(5); 
    public static final Long	ESTADO_OPERACION_RECHAZADO 	 = new Long(6); 
    public static final Long	ESTADO_RECLAMO_DIGITADO 	 = new Long(1); 
    public static final Long	ESTADO_RECLAMO_INGRESADO 	 = new Long(2); 
    public static final Long	ESTADO_RECLAMO_BLOQUEADO 	 = new Long(3); 
    public static final Long	ESTADO_RECLAMO_FACTURADO 	 = new Long(4); 
    public static final Long	ESTADO_RECLAMO_RECHAZADO 	 = new Long(5); 
    public static final Long	ESTADO_RECLAMO_PARCIAL 	     = new Long(8); 
    public static final Long	TIPO_INGRESO_DIGITACION 	 = new Long(1); 
    public static final Long	TIPO_INGRESO_LINEA 			 = new Long(2); 
    public static final Long	TIPO_MOVIMIENTO_ENVIA 		 = new Long(1); 
    public static final Long	TIPO_MOVIMIENTO_DEVUELVE 	 = new Long(2); 
    public static final Long	PRECIO_ENVIA_FACTURA 		 = new Long(1); 
    public static final Long	PRECIO_ENVIA_CATALOGO 		 = new Long(2); 
    public static final Long	PRECIO_PERDIDA_VENTA 		 = new Long(2); 
    public static final Long	PRECIO_PERDIDA_CATALOGO 	 = new Long(1); 
    public static final Long	PRECIO_PRECIOS 				 = new Long(1); 
    public static final Long	PRECIO_PREMIOS 				 = new Long(2); 
    public static final String	MATRIZ_PRECIOS 				 = "P"; 
    public static final String	MATRIZ_PREMIOS 				 = "I"; 
    public static final String	BLOQUEO_IMPORTE_MAXIMO 		 = "I"; 
    public static final String	BLOQUEO_DIFERENCIA_IMPORTES  = "M";
    public static final String  BLOQUEO_UNIDADES_DEVUELTAS = "U";
    public static final String  BLOQUEO_RECLAMO_ANTERIOR = "R";
    public static final Long IND_MERCADERIA_S = new Long(1); 
    public static final Long IND_MERCADERIA_N = new Long(2); 
    public static final Long IND_MERCADERIA_C = new Long(3); 
    public static final Character ESTADO_LINEA_ENVIADO = new Character('E'); // BELC300014716
    public static final String ESTADO_LINEA_INGRESADO = "I"; 
    public static final Long ESTADO_RECLAMO_ENVIADO = new Long(6); 
    public static final Long ESTADO_OPERACION_DIGITADO = new Long(7);
    public static final Long ESTADO_GENERACION_PROVISIONAL = new Long(1);
    public static final String	MOVIMIENTO_ENVIA 		 = "E"; //BELC300015066
    public static final String	MOVIMIENTO_DEVUELVE 	 = "D"; //BELC300015066
    public static final Long REC034 = new Long(8); // BELC300014949
    
    public static final Long	CHEQUEO_MANUAL 	    	 = new Long(1); // Incidencia Sicc20080563
    public static final Long	CHEQUEO_EN_LINEA 	     = new Long(2); // Incidencia Sicc20080563
    public static final Long	CHEQUEO_EN_CAMPO       = new Long(3); // Incidencia Sicc20080563
    public static final String  PERIODO_FACTURA      = "F";  // Incidencia Sicc20080563
    public static final String  PERIODO_RECLAMO      = "R";  // Incidencia Sicc20080563
    
    //aniadidas en el N41 B    
    public static final Long TIPO_INGRESO_MASIVO = new Long(3); 
    public static final Long ESTADO_GENERACION_ENVIADO  = new Long(2);   
    public static final Long ESTADO_GENERACION_ANULADO  = new Long(3);  
    //REC-09 mamontie 15/12/2005
    public static final Long ESTADO_RECLAMO_ERROR  = new Long(7);   
    public static final Long ESTADO_OPERACION_ERROR  = new Long(8);   
    
    //BELC300021984
    public static final Long IND_SOLICITUD_NEGATIVA_TRUE = new Long(1);
    public static final Long IND_SOLICITUD_NEGATIVA_FALSE = new Long(0);
    
    public static final String BLOQUEO_POR_CHEQUEO = "CK";
    
    public static final String MOVIMIENTO_ALMACEN = "MA";
    public static final String GENERAR_SOLICITUD = "GS";
    public static final String  RECOJO_RECLAMO_LINEA	=	"RL";
    public static final String  RECOJO_RECLAMO_MASIVO	=	"RM";
    public static final String  PRIMER_RECOJO_NO_EXITOSO =	"PRNE";
    public static final String  SEGUNDO_RECOJO_NO_EXITOSO	=	"SRNE";
    public static final String  RECOJO_INICIAL =	"RI";
    public static final String  RECLAMO_DIGITADO =	"RD";
    public static final String  OPERCION_REC055 =	"REC055";
    public static final String  PENDIENTE_RECOJO = "PR";
    public static final String  NO_EXITOSO = "NE";
    public static final String  EXITOSO = "SE";
    public static final String  ANULADO = "AN";
    public static final String  VALIDACION_OK = "OK";
    
    public static final String  VALIDACION_ERRONEA = "Numero Boleta Erróneo";
    public static final String  VALIDACION_KO = "KO";
    
    public static final Long OID_PRIMER_RECOJO  = new Long(1);   
    public static final Long OID_SEGUNDO_RECOJO  = new Long(2);   

    public static final Long OID_SI_EXITOSO  = new Long(1);   
    public static final Long OID_NO_EXITOSO  = new Long(2);    
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009    
    public static final Long OID_TIPO_ORDEN_CHEQU_MANUAL = new Long(1);   
    public static final Long OID_TIPO_ORDEN_CHEQU_LINEA = new Long(2);   
    public static final Long OID_TIPO_ORDEN_CHEQU_CAMPO = new Long(3);   
    
    public static final String COD_TIPO_REVISION_LINEA  = "L";
    public static final String COD_TIPO_REVISION_CAMPO  = "C";
    public static final String COD_TIPO_REVISION_AMBOS  = "A";     
    public static final Long OID_TIPO_REVISION_LINEA  = new Long(1);   
    public static final Long OID_TIPO_REVISION_CAMPO  = new Long(2);   
    public static final Long OID_TIPO_REVISION_AMBOS  = new Long(3);   
    
    public static final String COD_TIPO_REVISION_A  = "A";
    public static final String COD_TIPO_REVISION_B  = "B";
    public static final String COD_TIPO_REVISION_C  = "C";
    public static final String COD_TIPO_REVISION_D  = "D";
    public static final String COD_TIPO_REVISION_E  = "E";
    public static final String COD_TIPO_REVISION_F  = "F";
    public static final String COD_TIPO_REVISION_G  = "G";
    public static final String COD_TIPO_REVISION_H  = "H";
    public static final String COD_TIPO_REVISION_I  = "I";
    public static final String COD_TIPO_REVISION_X  = "X";
    public static final String COD_TIPO_REVISION_Y  = "Y";
    public static final String COD_TIPO_REVISION_Z  = "Z";
    
    public static final Long OID_TIPO_REVISION_A  = new Long(1);   
    public static final Long OID_TIPO_REVISION_B  = new Long(2);   
    public static final Long OID_TIPO_REVISION_C  = new Long(3);   
    public static final Long OID_TIPO_REVISION_D  = new Long(4);   
    public static final Long OID_TIPO_REVISION_E  = new Long(5);   
    public static final Long OID_TIPO_REVISION_F  = new Long(6);   
    public static final Long OID_TIPO_REVISION_G  = new Long(7);   
    public static final Long OID_TIPO_REVISION_H  = new Long(8);   
    public static final Long OID_TIPO_REVISION_I  = new Long(9);   
    public static final Long OID_TIPO_REVISION_X  = new Long(10);   
    public static final Long OID_TIPO_REVISION_Y  = new Long(11);   
    public static final Long OID_TIPO_REVISION_Z  = new Long(12); 
    //Agregado por cambio 20080765    
    public static final String  OPERCION_REC060 =   "REC060";
}