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
package es.indra.sicc.logicanegocio.dto;

public class ConstantesDTO  {

    public static final Character DESCUENTO_FUTURO = new Character('F');
    public static final Character DESCUENTO_VIGENTE = new Character('V');
    public static final Character DESCUENTO_CADUCADO = new Character('C');         
    public static final String NOMBRE_DESCUENTO_ESPECIAL_CLIENTE = "Descuento especial a cliente numero";
    
    public static final Integer PESTANYA_DATOS_GENERALES = new Integer(0);
    public static final Integer PESTANYA_TIPO_CLIENTES = new Integer(1);
    public static final Integer PESTANYA_ALCANCE_ADMINISTRATIVO = new Integer(2);
    public static final Integer PESTANYA_BASE_CALCULO = new Integer(3);
    public static final Integer PESTANYA_BASE_APLICACION = new Integer(4);
    
}