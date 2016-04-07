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

public class ErroresDeNegocio  {
    //REC-0001 El codigo de producto introducido no existe
    public final static String PRODUCTO_NO_EXISTE = "0001";
    
    //REC-0002 El usuario no esta autorizado a realizar la operación
    public final static String USUARIO_NO_AUTORIZADO = "0002";
    
    //REC-0003 El importe de la operación supera el importe autorizado para el usuario
    public final static String SUPERADO_IMPORTE_AUTORIZADO = "0003";
    
    //REC-0004 La diferencia de importes supera la autorizada para el usuario
    public final static String SUPERADA_DIFERENCIA_AUTORIZADA = "0004";
    
    public final static String  REC_0005 ="0005"; //El código de venta origen o destino no son válidos. Revise los datos
    
    public final static String  REC_0006 ="0006"; //Ya existe un motivo de devolución por defecto definido para la operación

    // Añadido por la BELC300019018
    // No se puede anular dicha solicitud al existir un reclamo previo sobre el documento
    public final static String  REC_0007 ="0007"; 
    
    // COL-STO-001 - dmorello, 21/02/2008
    public final static String REC_0008 = "0008";  // Producto no existe
    
    // COL-STO-001 - dmorello, 11/03/2008
    public final static String REC_0009 = "0009";  // Código venta no existe
    
    // COL-STO-001 - enguanco, 17/04/2008
    public final static String REC_0010 = "0065"; //  codigo de producto introducido no existe
    
    // vbongiov -- 22/04/2008
    public final static String REC_TIPO_ATENCION_OCR_REPETIDA = "0010"; 
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public final static String CHEQUEO_YA_DEFINIDO = "0011"; 
    public final static String PERIODO_YA_GENERADO = "0012"; 
}