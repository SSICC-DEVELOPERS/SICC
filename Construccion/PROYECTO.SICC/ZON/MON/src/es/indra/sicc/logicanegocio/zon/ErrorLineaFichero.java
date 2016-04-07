/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

/**
 * Se utiliza para ir guardando los errores del proceso de rezonificacion en
 * primera fase, y luego registrarlos en el archivo de Log.
 * Creado para inc. DBLG500000146
 * @autor: Emilio Iraola
 * @date: 14/09/2006
 */
public class ErrorLineaFichero {
    int nroLinea;
    String descError;
  
    public ErrorLineaFichero() {
    }
    
    public ErrorLineaFichero(int linea, String error) {
        this.nroLinea = linea;
        this.descError = error;
    }

    public void setNroLinea(int nroLinea) {
        this.nroLinea = nroLinea;
    }

    public int getNroLinea() {
        return nroLinea;
    }

    public void setDescError(String descError) {
        this.descError = descError;
    }

    public String getDescError() {
        return descError;
    }

}
