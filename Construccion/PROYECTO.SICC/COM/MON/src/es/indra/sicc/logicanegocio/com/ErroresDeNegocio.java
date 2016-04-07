/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.com;

public class ErroresDeNegocio {
    //public final static String COB_0008 = "0010001";
    
    // by ssantana, 15/3/2005
    public final static String COM_0001 = "0010001"; // Error sin determinar
    public final static String COM_0002 = "0010002"; // No se puede grabar. Existe una comisi�n activa para la plantilla.
    public final static String COM_0003 = "0010003"; // No se puede copiar la comisi�n. La plantilla no est� activa.
    public final static String COM_0004 = "0010004"; // No se puede copiar la comisi�n. El canal de la plantilla y de la comisi�n no coinciden.
    public final static String COM_0005 = "0010005"; // No se puede copiar la comisi�n. El tipo de comisi�n de la plantilla y de la comisi�n no coinciden.
    public final static String COM_0006 = "0010006"; // No se puede copiar la comisi�n. La marca de la comisi�n no se encuentra activa en la plantilla.
    public final static String COM_0007 = "0010007"; // No se puede copiar la comisi�n. Alguno de los accesos de la comisi�n no se encuentra activo en la plantilla.
    public final static String COM_0008 = "0010008"; // No se puede eliminar. Existe una comisi�n activa para la plantilla.
    public final static String COM_0009 = "0010009"; // No se encuentra el c�digo de producto.
    public final static String COM_0010 = "0010010"; // El cliente ya est� dado de alta como congelado
    public final static String COM_0011 = "0010011"; // Debe especificar al menos un tipo de cliente para la comisi�n
    //Provisorio, esperando respuesta de incidencia 16200
    public final static String COM_0012 = "0010012"; // Debe especificar los campos requeridos en Datos c�lculo comisi�n
    public final static String COM_0013 = "0010013"; // Debe especificar los campos requeridos en Datos generales comisi�n
    public final static String COM_0014 = "0010014";
    public final static String COM_0015 = "0010015"; // No se pueden calcular metas ya que la comision no es incremental de venta historica
    public final static String COM_0016 = "0010016"; //El c�digo de cliente que desea congelar no existe.
    public final static String COM_0017 = "0010017"; //El cliente ya se encuentra en estado de congelaci�n
    public final static String COM_0018 = "0010018"; //No existen registros para los criterios de b�squeda utilizados.
}