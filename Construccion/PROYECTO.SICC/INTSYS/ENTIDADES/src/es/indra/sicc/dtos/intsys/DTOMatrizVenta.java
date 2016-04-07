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
import java.math.BigDecimal;

public class DTOMatrizVenta extends DTOBelcorp  {
    private String codigoCanalVenta;
    private String anioCampania;
    private String codigoProducto;
    private String codigoTipoOferta;
    private String codigoVenta;
    private String descripcionTipoOferta;
    private BigDecimal precioOferta;
    private Boolean flagEstadisticable;
    private String flagTipoAccion;

    public DTOMatrizVenta() {
    }

    public String getCodigoCanalVenta() {
        return codigoCanalVenta;
    }

    public void setCodigoCanalVenta(String codigoCanalVenta) {
        this.codigoCanalVenta = codigoCanalVenta;
    }

    public String getAnioCampania() {
        return anioCampania;
    }

    public void setAnioCampania(String anioCampania) {
        this.anioCampania = anioCampania;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoTipoOferta() {
        return codigoTipoOferta;
    }

    public void setCodigoTipoOferta(String codigoTipoOferta) {
        this.codigoTipoOferta = codigoTipoOferta;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getDescripcionTipoOferta() {
        return descripcionTipoOferta;
    }

    public void setDescripcionTipoOferta(String descripcionTipoOferta) {
        this.descripcionTipoOferta = descripcionTipoOferta;
    }

    public BigDecimal getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigDecimal precioOferta) {
        this.precioOferta = precioOferta;
    }

    public Boolean getFlagEstadisticable() {
        return flagEstadisticable;
    }

    public void setFlagEstadisticable(Boolean flagEstadisticable) {
        this.flagEstadisticable = flagEstadisticable;
    }

    public String getFlagTipoAccion() {
        return flagTipoAccion;
    }
}