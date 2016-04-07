
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
package es.indra.sicc.logicanegocio.zon;

public class ConstantesZON  {

	public static final Long IND_ACTIVO = new Long(1); 
	public static final Long IND_INACTIVO = new Long(0);
	public static final String TIPO_OPERACION_TRASVASE = "T";
	public static final String TIPO_OPERACION_FUSION = "F";;
	public static final String TIPO_OPERACION_PARTICION = "P";
	public static final String TIPO_MODIFICACION_TRASVASE = "T";
	public static final String TIPO_MODIFICACION_FUSION = "F";;
	public static final String TIPO_MODIFICACION_PARTICION = "P";
    public static final String CODIGO_ESTADO_INICIAL = "1";
    
    //PENDIENTE INCIDENCIA 18774
    public static final Integer IND_SUBGERENCIA = new Integer(1);
    public static final Integer IND_REGION = new Integer(2);
    public static final Integer IND_ZONA = new Integer(3);
    public static final Integer IND_SECCION = new Integer(4);
    //FIN DEPENDENCIA
    
    // Incidencia 22640 - dmorello, 21/02/2006
    public static final Long CODIGO_OTRO_ESTADO = new Long(2);
}