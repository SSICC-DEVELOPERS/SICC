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
package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTTipoOferta extends DTOBelcorp  {
    private String codigoCanal;
    private String codigoTipoOferta;
    private String descripcionTipoOferta;
    private String codigoTipoProfit;

    public DTOINTTipoOferta() {
    }

    public String getCodigoCanal() {
        return codigoCanal;
    }

    public void setCodigoCanal(String codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    public String getCodigoTipoOferta() {
        return codigoTipoOferta;
    }

    public void setCodigoTipoOferta(String codigoTipoOferta) {
        this.codigoTipoOferta = codigoTipoOferta;
    }

    public String getDescripcionTipoOferta() {
        return descripcionTipoOferta;
    }

    public void setDescripcionTipoOferta(String descripcionTipoOferta) {
        this.descripcionTipoOferta = descripcionTipoOferta;
    }

    public String getCodigoTipoProfit() {
        return codigoTipoProfit;
    }

    public void setCodigoTipoProfit(String codigoTipoProfit) {
        this.codigoTipoProfit = codigoTipoProfit;
    }
}