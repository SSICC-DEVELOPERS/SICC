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

public class SerializadorMAV extends Serializador {

    public static final String CODIGO_BARRAS = "&Barras";
    public static final String REMISION = "&Remision";
    public static final String TELEFONO = "&InfTelef";
    public static final String CAMPANIA = "&Campa";
    public static final String ANIO = "&Anio";
    public static final String FECHA = "&InfFecha";
    public static final String TERRITORIO = "&Territorio";
    public static final String NOMBRE_CLIENTE = "&InfNomBr";
    public static final String DIRECCION = "&InfDirec";
    public static final String CIUDAD = "&InfNomCiu";
    public static final String DEPARTAMENTO = "&InfDepar";
    public static final String CARGO = "&InfCargo";
    public static final String NUMERO_CAJA = "&i";
    public static final String NUMERO_TOTAL_CAJAS = "&n";
    public static final String REGION = "&Region";
    public static final String ZONA = "&Zona";

    // Cambio APE-10 - dmorello, 24/06/2008
    public static final String BARRIO = "&Barrio";


    /**
     * CHANGELOG
     * ---------
     * dmorello, 24/06/2008: Cambio APE-10
     *                       Se elimina la serializacion del dato variable CIUDAD
     *                       reemplazándolo por BARRIO.
     *                       Se agrega texto fijo "BARRIO:"
     */
    public SerializadorMAV() {
        // Se carga el atributo "zpl" con el codigo ZPL para etiquetas MAV
        StringBuffer sb = new StringBuffer();

        sb.append("^XA");  // Inicio del script
        
        /* Configuraciones de impresion */
        sb.append("^PRE");
        sb.append("^LL800");    // Longitud máxima de etiqueta = 719 puntos
        sb.append("^PW900");    // Ancho de impresion = 800 puntos
        sb.append("^LH0,0^FS"); // Esquina superior izquierda en 0,0
        
        /* Textos fijos */
        // Cambio APE-04 - dmorello, 15/11/2007: Cambio Remisión por Consolidado
        sb.append("^FO22,220^A0N,31,0^CI0^FR^FDConsolidado:^FS");
        sb.append("^FO500,220^A0N,31,0^CI0^FR^FDRegión/Zona:^FS");
        sb.append("^FO22,478^A0N,39,0^CI0^FR^FDBARRIO:^FS");
        sb.append("^FO26,560^A0N,29,0^CI0^FR^FDTel: ^FS");
        sb.append("^FO24,607^A0N,29,0^CI0^FR^FDCampaña:^FS");
        sb.append("^FO24,658^A0N,29,0^CI0^FR^FDFecha:^FS");
        sb.append("^FO326,560^A0N,29,0^CI0^FR^FDCaja:^FS");
        sb.append("^FO599,560^A0N,29,0^CI0^FR^FDCargo:^FS");
        
        /* Líneas y rectángulos */
        sb.append("^FO10,206^GB807,0,6^FS");
        sb.append("^FO16,366^GB799,0,6^FS");
        sb.append("^FO10,526^GB809,0,6^FS");
        sb.append("^FO12,544^GB290,0,6^FS");
        sb.append("^FO8,206^GB0,326,6^FS");
        sb.append("^FO815,208^GB0,322,6^FS");
        sb.append("^FO10,548^GB0,164,6^FS");
        sb.append("^FO3309,1535^GB0,18,6^FS");
        sb.append("^FO300,546^GB0,164,6^FS");
        sb.append("^FO12,707^GB292,0,6^FS");
        sb.append("^FO316,546^GB248,0,6^FS");
        sb.append("^FO314,546^GB0,164,6^FS");
        sb.append("^FO320,703^GB248,0,6^FS");
        sb.append("^FO562,546^GB0,164,6^FS");
        sb.append("^FO583,546^GB230,0,6^FS");
        sb.append("^FO583,546^GB0,164,6^FS");
        sb.append("^FO583,703^GB230,0,6^FS");
        sb.append("^FO811,546^GB0,162,6^FS");
        sb.append("^FO450,206^GB0,160,6^FS");
        
        /* Parte variable (datos) */
        sb.append("^FO163,560^A0N,29,0^CI0^FR^FD").append(TELEFONO).append("^FS");
        sb.append("^FO163,607^A0N,29,0^CI0^FR^FD").append(CAMPANIA).append(" de ").append(ANIO).append("^FS");
        sb.append("^FO163,658^A0N,29,0^CI0^FR^FD").append(FECHA).append("^FS");
        sb.append("^FO40,270^A0N,84,0^CI0^FR^FD").append(REMISION).append("^FS");
        sb.append("^FO500,270^A0N,84,0^CI0^FR^FD").append(REGION).append('/').append(ZONA).append("^FS");
        sb.append("^FO22,378^A0N,47,0^CI0^FR^FD").append(NOMBRE_CLIENTE).append("^FS");
        sb.append("^FO22,432^A0N,39,0^CI0^FR^FD").append(DIRECCION).append("^FS");
        sb.append("^FO160,478^A0N,39,0^CI0^FR^FD").append(BARRIO).append("^FS");
        sb.append("^FO460,478^A0N,39,0^CI0^FR^FD").append(DEPARTAMENTO).append("^FS");
        sb.append("^FO680,610^A0N,45,0^CI0^FR^FD").append(CARGO).append("^FS");
        sb.append("^FO325,600^A0N,72,0^CI0^FR^FD").append(NUMERO_CAJA).append("^FS");
        sb.append("^FO430,600^A0N,72,0^CI0^FR^FD/").append(NUMERO_TOTAL_CAJAS).append("^FS");
        
        /* Código de barras */
        sb.append("^BY3,3.0^FO320,54^BCN,113,Y,N,N^FR^FD").append(CODIGO_BARRAS).append("^FS");
        
        sb.append("^XZ");  // Fin del script
        
        this.zpl = sb.toString();
    }
}