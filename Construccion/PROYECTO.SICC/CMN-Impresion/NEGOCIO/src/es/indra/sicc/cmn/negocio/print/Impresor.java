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
package es.indra.sicc.cmn.negocio.print;

import es.indra.mare.common.exception.MareException;

import sos.net.print.LPR;


public class Impresor {
    //Indidencia 10830 resuelta 
    private String host;
    private Integer port;
    private String printerName;
    final Integer timeOut = new Integer(60 * 1000);

    public Impresor(String host, Integer port, String printerName) {
        this.host = host;
        this.port = port;
        this.printerName = printerName;
    }

    public LPR conectar() {
        /*
        ENTRADA:
        SALIDA:
        RESUMEN: Carga la configuración del cliente LPR

        1.- Llamo al constructor de la clase LPR pasando como parámetros los atributos (host, port, name)
        2.- De la nueva instancia que hemos creado llamamos a su método setTimeout pasandole el atributo timeOut.
        3. Devolvemos el objeto LPR.
         */
        LPR lpr = new LPR(this.host, this.port.intValue(), this.printerName);

        lpr.setTimeout(this.timeOut.intValue());

        return lpr;
    }

    public void imprimir(byte[] entrada) throws MareException {
        /*ENTRADA: byte[] entrada
        SALIDA:
        RESUMEN: Imprime el array de bytes[]

        1.- Llamo al método privado conectar() que devuelve un objeto de tipo LPR.
        2.- Llamo al método print() del objeto LPR obtenido en el paso anterior pasandole
        como parámetros name(atributo), entrada(parámetro cabecera) y " ". */
        LPR lpr = this.conectar();

        lpr.print(this.printerName, entrada, " ");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String newHost) {
        host = newHost;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer newPort) {
        port = newPort;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String newPrinterName) {
        printerName = newPrinterName;
    }
}
