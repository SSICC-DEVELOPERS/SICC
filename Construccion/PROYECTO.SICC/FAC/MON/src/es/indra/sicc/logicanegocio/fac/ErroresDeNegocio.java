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


/**
 * En esta clase se definen constantes que hacen referencia
 * a codigos de errores de negocio del módulo FAC.
 */
public class ErroresDeNegocio {

    //FAC-0001 Periodo ya cerrado
    public final static String PERIODO_CERRADO = "0001";
	
    //FAC-0002 Región ya cerrada
    public final static String REGION_CERRADA = "0002";

	//FAC-0003 Zona ya cerrada
	public final static String ZONA_CERRADA = "0003";
	
    //FAC-0004 El proceso ejecutado ha producido un error: 
    public final static String PROCESO_EJECUTADO_ERROR = "0004";
    
    //FAC-0007 Existen registros para el mismo Pais y Tipo de Oferta, con fechas solapadas
    public final static String FECHAS_SOLAPADAS = "0007";  
    
    public final static String FAC_0001=    "0001";
    public final static String FAC_0002=    "0002";
    public final static String FAC_0003=    "0003";
    public final static String FAC_0004=    "0004";
    public final static String FAC_REP_0001=    "0101";
    public final static String FAC_0007 =   "0007"; 
    public final static String FAC_0008 =   "0008";  
}
