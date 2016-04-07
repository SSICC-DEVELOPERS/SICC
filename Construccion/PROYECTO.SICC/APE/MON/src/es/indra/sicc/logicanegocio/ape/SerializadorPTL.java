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

public class SerializadorPTL extends Serializador {

    public static final String CODIGO_BARRAS = "&Barras";
    public static final String NUMERO_CONSOLIDADO_PRIMEROS = "&NumeroConsPrim";
    public static final String NUMERO_CONSOLIDADO_ULTIMOS = "&NumeroConsUlt";
    public static final String TERRITORIO = "&Territorio";
    public static final String NUMERO_CAJA = "&Caja";
    public static final String NUMERO_TOTAL_CAJAS = "&n";
    public static final String SECUENCIA_CAJA_PTL = "&cETBNumPTL";
    public static final String TALLA = "&Talla";
    public static final String NOMBRE_CLIENTE = "&Nombre";
    public static final String DIRECCION = "&Direccion";
    public static final String BARRIO = "&INFBARRIO";
    public static final String CIUDAD = "&Ciudad";
    public static final String DEPARTAMENTO = "&Dpto";
    public static final String CHEQUEO = "&Chequ";
    public static final String TIPO_CONSULTORA = "&DscTipCon";
    public static final String TEXTO_VARIABLE_1 = "&TextoVar1";
    public static final String TEXTO_VARIABLE_2 = "&TextoVar2";
    public static final String TEXTO_CHEQUEO = "CH";
    
    // Cambio APE-04 - dmorello, 10/01/2008
    // Se elimina por cambio 20090839 - dmorello, 16/09/2009
    //public static final String TEXTO_PRIMER_PEDIDO = "&TextPrimPedi";
    
    // Cambio 20090839 - dmorello, 03/09/2009
    public static final String LINEA_ARMADO = "&LineaArmado";
    public static final String FECHA_FACTURACION = "&FechaFact";
    
    /**
     * CHANGELOG
     * ---------
     * dmorello, 10/01/2008 - Cambio APE-04
     *                        Cambio texto fijo FACTURA por CONSOLIDADO.
     *                        Se corre aprox. 1 digito a la izquierda el campo
     *                        Secuencia caja PTL; se agrega el campo Texto
     *                        Primer Pedido.
     * dmorello, 24/06/2008 - Cambio APE-10
     *                        Se agrega texto fijo "BARRIO:".
     *                        Se modifica posición de texto variable Barrio
     * dmorello, 16/09/2009 - Cambio 20090839
     *                        Se modifica el formato de la etiqueta
     *                        Se agregan datos: linea de armado, fecha de facturacion
     *                        Se eliminan datos: numero factura, texto primer pedido, departamento
     *                        Se renombra numero factura a consolidado
     * dmorello, 12/11/2009 - Incidentes cambio 20090839
     *                        Se imprimen los 4 primeros digitos del consolidado en un tamaño menor
     */
    public SerializadorPTL() {
        // Se carga el atributo "zpl" con el codigo ZPL para etiquetas PTL
        StringBuffer sb = new StringBuffer();

        sb.append("^XA"); // Inicio del script
        
        /* Configuraciones de impresión */
        sb.append("^PRE");
        sb.append("^LL800");    // Longitud máxima de etiqueta = 800 puntos
        sb.append("^PW900");    // Ancho de impresion = 900 puntos
        sb.append("^LH0,0^FS"); // Esquina superior izquierda en 0,0
        
        /* Textos fijos */
        sb.append("^FO28,40^A0N,28,0^CI0^FR^FDCONSOLIDADO^FS");
        sb.append("^FO20,183^A0N,23,0^CI0^FR^FDCODIGO TERRITORIAL^FS");
        sb.append("^FO305,183^A0N,23,0^CI0^FR^FDCAJA^FS");
        sb.append("^FO490,183^A0N,23,0^CI0^FR^FDTIPO^FS");
        sb.append("^FO21,394^A0N,36,0^CI0^FR^FDBARRIO:^FS");
        sb.append("^FO28,625^A0N,23,0^CI0^FR^FDFACTURACION^FS");
        
        /* Rectángulos y líneas */
        sb.append("^FO8,30^GB590,140,4^FS");     // Recuadro numero consolidado
        sb.append("^FO8,166^GB288,110,4^FS");    // Recuadro codigo territorial
        sb.append("^FO290,166^GB195,110,4^FS");  // Recuadro numero caja
        sb.append("^FO480,166^GB118,110,4^FS");  // Recuadro tipo caja
        sb.append("^FO8,271^GB590,210,4^FS");    // Recuadro datos cliente
        sb.append("^FO8,477^GB390,145,4^FS");    // Recuadro secuencial
        sb.append("^FO394,477^GB204,145,4^FS");  // Recuadro texto chequeo (CH)
        sb.append("^FO8,618^GB390,95,4^FS");     // Recuadro fecha facturacion
        sb.append("^FO394,618^GB430,95,4^FS");   // Recuadro texto variable
        sb.append("^FO594,30^GB230,592,4^FS");   // Recuadro codigo de barras
        
        /* Parte variable (datos) */
        sb.append("^FO284,66,1^A0N,80,0^FD").append(NUMERO_CONSOLIDADO_PRIMEROS).append("^FS");
        sb.append("^FO294,66^A0N,130,0^FD").append(NUMERO_CONSOLIDADO_ULTIMOS).append("^FS");
        sb.append("^FO570,40,1^A0N,28,0^CI0^FR^FD").append(LINEA_ARMADO).append("^FS");
        sb.append("^FO20,207^A0N,73,0^CI0^FR^FD").append(TERRITORIO).append("^FS");
        sb.append("^FO300,207^A0N,55,0^CI0^FR^FD").append(NUMERO_CAJA).append('/').append(NUMERO_TOTAL_CAJAS).append("^FS");
        sb.append("^FO500,207^A0N,67,0^CI0^FR^FD").append(TALLA).append("^FS");

        sb.append("^FO10,490^A0N,160,0^CI0^FR^FD").append(SECUENCIA_CAJA_PTL).append("^FS");
        sb.append("^FO24,650^A0N,73,0^CI0^FR^FD").append(FECHA_FACTURACION).append("^FS");

        // Datos del cliente
        sb.append("^FO21,290^A0N,36,0^CI0^FR^FD").append(NOMBRE_CLIENTE).append("^FS");
        sb.append("^FO21,346^A0N,36,0^CI0^FR^FD").append(DIRECCION).append("^FS");
        sb.append("^FO160,394^A0N,36,0^CI0^FR^FD").append(BARRIO).append("^FS");
        sb.append("^FO21,442^A0N,36,0^CI0^FR^FD").append(CIUDAD).append("^FS");
        
        // Marca de chequeo
        sb.append("^FO405,500^A0N,140,0^CI0^FR^FD").append(CHEQUEO).append("^FS");
        
        // Texto variable dividido en dos renglones
        sb.append("^FO400,635^A0N,32,0^CI0^FR^FD").append(TEXTO_VARIABLE_1).append("^FS");
        sb.append("^FO400,670^A0N,32,0^CI0^FR^FD").append(TEXTO_VARIABLE_2).append("^FS");
        
        // Código de barras
        sb.append("^BY3,3.0^FO630,90^BCB,150,Y,N,N^FR^FD").append(CODIGO_BARRAS).append("^FS");

        sb.append("^XZ");  // Fin del script
        
        this.zpl = sb.toString();
    }
}