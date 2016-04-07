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
package es.indra.sicc.dtos.msg;

public class ConstantesMSG  {

    public static final String AL_FINAL = "Al final";
    public static final Long PRIMER_PATRON_PERIODO = new Long(0);
    public static final String SI = "S";
    public static final String NO = "N";
    public static final String VACIO = "";
    public static final Long OID_PERMANENCIA_U = new Long(2);
    public static final Long OID_PERMANENCIA_H = new Long(3);    
    public static final Long OID_PERMANENCIA_R = new Long(4);
    public static final Long OID_UNIDAD_ADMINISTRATIVA = new Long(1);    
    public static final Long OID_CLASIFICACION_CLIENTE = new Long(2);
    public static final Long OID_MARCA = new Long(3);     
    public static final Long OID_CODIGO_VENTA = new Long(4);    
    public static final Long OID_PEDIDO = new Long(5);   
    public static final Long OID_CONSULTORAS = new Long(6);    
    public static final Long OID_PAIS = new Long(1);    
    public static final Long OID_REGION = new Long(2);    
    public static final Long OID_ZONA = new Long(3);
    public static final Long OID_SECCION = new Long(4);
    public static final Long OID_TERRITORIO = new Long(5);
    public static final Long OID_TIPO_CLIENTE = new Long(1);
    public static final Long OID_SUBTIPO_CLIENTE = new Long(2);
    public static final Long OID_TIPO_CLASIFICACION = new Long(3);
    public static final Long OID_CLASIFICACION = new Long(4);
    public static final Long OID_TIPO_G1 = new Long(1);
    public static final Long OID_TIPO_G2 = new Long(2);
    public static final Long OID_TIPO_G3 = new Long(3);
    public static final String COPIAR_PATRON = "####";
    public static final String MENSAJE_PED01 = "PED01";
    public static final String MENSAJE_PED02 = "PED02";
    public static final String MENSAJE_PED03 = "PED03";
    public static final String MENSAJE_PED04 = "PED04";
    public static final String MENSAJE_PED07 = "PED07";
	public static final String MENSAJE_PRE02 = "PRE02";
    public static final String MENSAJE_PED05 = "PED05";
	public static final String MENSAJE_PED08 = "PED08"; 
	public static final String MENSAJE_PED10 = "PED10";
    //-------------------------------------------------------------------------
    /*la linea inferior fue agregada por incidencia 9780 que viene de la 9460*/
	public static final String MENSAJE_CCC03 = "CCC03";
    //modificó hmansi-02/11/2004-----------------------------------------------
	public static final Integer IND_ACTIVO = new Integer(1);
	public static final Integer IND_INACTIVO = new Integer(0);
	public static final String MODULO_MSG = "MSG";
	public static final Long OID_METACARACTER_C = new Long(1);
	public static final Long OID_METACARACTER_F = new Long(2);
	public static final Long OID_METACARACTER_E = new Long(3);	
	public static final String MENSAJE_MAV05 = "MAV05";
  
    //modificço Cortaberria 12/1/05
    public static final String MENSAJE_CAR01 = "CAR01";
    public static final String MENSAJE_CAR02 = "CAR02";
    
    //modificó idedough 13/1/05
    public static final String CARACTER_MENOR = "<";
    public static final String ESCAPE_CARACTER_MENOR = "&lt;";  
    //public static final String CARACTER_MAYOR = ">";
    //public static final String ESCAPE_CARACTER_MAYOR = "&lt;";
    
    public static final Long NUM_ATRIBUTO = new Long(1);	//inc.14024
    
    public static final String MENSAJE_DTO01 = "DTO01";
    public static final String MENSAJE_DTO02 = "DTO02"; 
    
    //modificó mgrodriguez 12/08/2005
    public static final String IND_METACAR_ACTIVADO = "A";
    public static final String IND_METACAR_DESACTIVADO = "D";
    
    // Agregado por enozigli, 14/20/2005, GCC-REC-003
    // Se agrega MENSAJE_REC02 x inc. 21092
    public static final String MENSAJE_REC02 = "REC02";
    public static final String MENSAJE_REC03 = "REC03";
    public static final String MENSAJE_REC04 = "REC04";
    public static final String MENSAJE_REC05 = "REC05";
    public static final String MENSAJE_REC06 = "REC06";
    public static final String MENSAJE_REC07 = "REC07";
    // Fin agregado enozigli, 14/20/2005, GCC-REC-003
    
    // DBLG500000894 - dmorello, 23/08/2006
    public static final String TAG_FIJO_APERTURA = "<fijo>";
    public static final String TAG_FIJO_CIERRE = "</fijo>";
    // Fin dmorello 23/08/2006
}