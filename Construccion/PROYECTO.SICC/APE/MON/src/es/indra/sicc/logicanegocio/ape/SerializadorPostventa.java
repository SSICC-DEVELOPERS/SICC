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

public class SerializadorPostventa extends Serializador {

    public static final String CAMPANIA = "&Campa";
    public static final String ANIO = "&Anio";
    public static final String FECHA = "&InfFecha";
    public static final String TERRITORIO = "&Territorio";
    public static final String BOLETA_ENTREGA = "&NumBolC";
    public static final String NOMBRE_CLIENTE = "&InfNomBr";
    public static final String DIRECCION = "&InfDirec";
    public static final String BARRIO = "&Barrio";
    public static final String CIUDAD = "&InfNomCiu";
    public static final String DEPARTAMENTO = "&InfDepar";
    public static final String SECCION = "&InfSeccion";
    public static final String CODIGO_BARRAS = "&Barras";
    public static final String NUMERO_CAJA = "&i";
    public static final String NUMERO_TOTAL_CAJAS = "&n";
    
    
    public SerializadorPostventa() {
        // Se carga el atributo "zpl" con el codigo ZPL para etiquetas Postventa
        StringBuffer sb = new StringBuffer();

        sb.append("^XA");  // Inicio del script
        
        /* Configuraciones de impresion */
        sb.append("^PRE");
        sb.append("^LL800");    // Longitud máxima de etiqueta = 719 puntos
        sb.append("^PW900");    // Ancho de impresion = 800 puntos
        sb.append("^LH0,0^FS"); // Esquina superior izquierda en 0,0
        
        /* Textos fijos de la etiqueta */
        sb.append("^FO22,220^A0N,31,0^CI0^FR^FDCódigo Territorial:^FS");
        sb.append("^FO380,220^A0N,31,0^CI0^FR^FDBoleta de entrega No.:^FS");
        sb.append("^FO022,465^A0N,31,0^CI0^FR^FDBarrio :^FS");
        sb.append("^FO24,607^A0N,29,0^CI0^FR^FDCampaña:^FS");
        sb.append("^FO24,658^A0N,29,0^CI0^FR^FDFecha:^FS");
        sb.append("^FO326,560^A0N,29,0^CI0^FR^FDCaja:^FS");
        sb.append("^FO599,560^A0N,29,0^CI0^FR^FDSección:^FS");
        
        /* Rectángulos y líneas */
        sb.append("^FO15,206^GB0,338,6^FS");
        sb.append("^FO15,546^GB0,164,6^FS");
        sb.append("^FO300,546^GB0,164,6^FS");
        sb.append("^FO314,546^GB0,164,6^FS");
        sb.append("^FO360,206^GB0,160,6^FS");
        sb.append("^FO562,546^GB0,164,6^FS");
        sb.append("^FO583,546^GB0,164,6^FS");
        sb.append("^FO809,206^GB0,338,6^FS");
        sb.append("^FO809,546^GB0,170,6^FS");
        sb.append("^FO15,206^GB800,0,6^FS");
        sb.append("^FO15,366^GB800,0,6^FS");
        sb.append("^FO15,546^GB290,0,6^FS");
        sb.append("^FO314,546^GB248,0,6^FS");
        sb.append("^FO583,546^GB230,0,6^FS");
        sb.append("^FO15,710^GB292,0,6^FS");
        sb.append("^FO314,710^GB248,0,6^FS");
        sb.append("^FO583,710^GB230,0,6^FS");
        
        /* Parte variable (datos) */
        sb.append("^FO163,607^A0N,29,0^CI0^FR^FD").append(CAMPANIA).append(" De ").append(ANIO).append("^FS");
        sb.append("^FO163,658^A0N,29,0^CI0^FR^FD").append(FECHA).append("^FS");
        sb.append("^FO40,270^A0N,88,0^CI0^FR^FD").append(TERRITORIO).append("^FS");
        sb.append("^FO380,270^A0N,88,0^CI0^FR^FD").append(BOLETA_ENTREGA).append("^FS");
        sb.append("^FO22,378^A0N,47,0^CI0^FR^FD").append(NOMBRE_CLIENTE).append("^FS");
        sb.append("^FO22,425^A0N,39,0^CI0^FR^FD").append(DIRECCION).append("^FS");
        sb.append("^FO163,465^A0N,39,0^CI0^FR^FD").append(BARRIO).append("^FS");
        sb.append("^FO22,508^A0N,39,0^CI0^FR^FD").append(CIUDAD).append("^FS");
        sb.append("^FO380,508^A0N,39,0^CI0^FR^FD").append(DEPARTAMENTO).append("^FS");
        sb.append("^FO680,601^A0N,95,0^CI0^FR^FD").append(SECCION).append("^FS");
        sb.append("^FO330,600^A0N,72,0^CI0^FR^FD").append(NUMERO_CAJA).append('/').append(NUMERO_TOTAL_CAJAS).append("^FS");
        
        /* Código de barras */
        sb.append("^BY3,3.0^FO320,54^BCN,113,Y,N,N^FR^FD").append(CODIGO_BARRAS).append("^FS");
        
        sb.append("^XZ");  // Fin del script
        
        this.zpl = sb.toString();
    }
}