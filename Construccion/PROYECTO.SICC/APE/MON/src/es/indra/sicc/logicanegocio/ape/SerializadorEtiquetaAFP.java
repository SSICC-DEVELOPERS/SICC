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
 *
 */

package es.indra.sicc.logicanegocio.ape;

public class SerializadorEtiquetaAFP extends Serializador {

    public static final String COMPANIA = "&Compania";
    public static final String REGION = "&Region";
    public static final String ZONA = "&Zona";
    public static final String CONSECUTIVO = "&Consecutivo";
    public static final String CAMPANIA = "&Campania";
    public static final String FECHA = "&InfFecha";
    public static final String NUMERO_CAJA = "&Estiba";
    public static final String NUMERO_TOTAL_CAJAS = "&n";
    public static final String SECCION = "&InfSeccion";
    public static final String CODIGO_BARRAS = "&Barras";
  
  
    public SerializadorEtiquetaAFP() {
        // Se carga el atributo "zpl" con el codigo ZPL para etiquetas AFP
        StringBuffer sb = new StringBuffer();
        
        sb.append("^XA"); // Inicio del script
        
        /* Configuraciones de impresion */
        sb.append("^PRE");
        sb.append("^LL800");    // Longitud máxima de etiqueta = 719 puntos
        sb.append("^PW900");    // Ancho de impresion = 800 puntos
        sb.append("^LH0,0^FS"); // Esquina superior izquierda = 0,0
        
        /* Textos fijos de la etiqueta */
        sb.append("^FO22,380^A0N,31,0^CI0^FR^FDRegión/Zona:^FS");
        sb.append("^FO380,380^A0N,31,0^CI0^FR^FDConsecutivo:^FS");
        sb.append("^FO24,607^A0N,29,0^CI0^FR^FDCampaña:^FS");
        sb.append("^FO24,658^A0N,29,0^CI0^FR^FDFecha:^FS");
        sb.append("^FO326,560^A0N,29,0^CI0^FR^FDCaja:^FS");
        sb.append("^FO599,560^A0N,29,0^CI0^FR^FDSección:^FS");
        
        /* Líneas y rectángulos */
        sb.append("^FO12,206^GB0806,166,6^FS");
        sb.append("^FO12,206^GB0,326,6^FS");
        sb.append("^FO360,366^GB0,166,6^FS");
        sb.append("^FO12,546^GB296,170,6^FS");
        sb.append("^FO314,546^GB254,170,6^FS");
        sb.append("^FO583,546^GB236,170,6^FS");
        sb.append("^FO12,366^GB0,166,6^FS");
        sb.append("^FO800,366^GB0,166,6^FS");        
        
        /* Parte variable (datos) */
        sb.append("^FO50,250^A0N,96,0^CI0^FR^FD").append(COMPANIA).append("^FS");
        sb.append("^FO32,425^A0N,70,0^CI0^FR^FD").append(REGION).append('-').append(ZONA).append("^FS");
        sb.append("^FO380,425^A0N,70,0^CI0^FR^FD").append(CONSECUTIVO).append("^FS");
        sb.append("^FO163,607^A0N,29,0^CI0^FR^FD").append(CAMPANIA).append("^FS");
        sb.append("^FO163,658^A0N,29,0^CI0^FR^FD").append(FECHA).append("^FS");
        sb.append("^FO680,601^A0N,95,0^CI0^FR^FD").append(SECCION).append("^FS");
        sb.append("^FO330,600^A0N,72,0^CI0^FR^FD").append(NUMERO_CAJA).append("^FS");
        sb.append("^FO430,600^A0N,72,0^CI0^FR^FD/").append(NUMERO_TOTAL_CAJAS).append("^FS");
        
        /* Código de barras */
        sb.append("^BY3,3.0^FO320,54^BCN,113,Y,N,N^FR^FD").append(CODIGO_BARRAS).append("^FS");
        
        sb.append("^XZ");    // Fin del script
        
        this.zpl = sb.toString();
    }
}