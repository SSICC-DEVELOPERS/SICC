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

public class DTOINTMatrizCampania extends DTOBelcorp  {
    private String codigoCanal;
    private String anioCampania;
    private String codigoProducto;
    private String codigoTipoOferta;
    private String codigoVenta;
    private String descripcionTipoOferta;
    private BigDecimal precioOferta;
    private Integer flagEstadisticable;
    // Cambio SiCC 20070511 - dmorello, 22/01/2008
    private String flagPerteneceProgramaSessionExpert;
    //SBUCHELLI
    private BigDecimal precioVenta;
    private BigDecimal precioVentaNormal;

    public DTOINTMatrizCampania() {
    }

    public String getCodigoCanal() {
        return codigoCanal;
    }

    public void setCodigoCanal(String codigoCanal) {
        this.codigoCanal = codigoCanal;
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

    public Integer getFlagEstadisticable() {
        return flagEstadisticable;
    }

    public void setFlagEstadisticable(Integer flagEstadisticable) {
        this.flagEstadisticable = flagEstadisticable;
    }

    public String getFlagPerteneceProgramaSessionExpert()
    {
      return flagPerteneceProgramaSessionExpert;
    }
  
    public void setFlagPerteneceProgramaSessionExpert(String flagPerteneceProgramaSessionExpert)
    {
      this.flagPerteneceProgramaSessionExpert = flagPerteneceProgramaSessionExpert;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getPrecioVentaNormal() {
        return precioVentaNormal;
    }

    public void setPrecioVentaNormal(BigDecimal precioVentaNormal) {
        this.precioVentaNormal = precioVentaNormal;
    }
}
