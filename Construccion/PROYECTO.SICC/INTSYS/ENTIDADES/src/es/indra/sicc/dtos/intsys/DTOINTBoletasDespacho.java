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
import java.util.Date;
import java.math.BigDecimal;

public class DTOINTBoletasDespacho extends DTOBelcorp  {
    private String anioCampania;
    private String codigoCanal;
    private String codigoAcceso;
    private Long numDocumentoFacturacion;
    private Long codigoTerritorio;
    private String codigoConsultora;
    private Long oidConsultora;
    private Date fechaDocumento;
    private Long oidClienteReceptor;
    private Integer flagAnulacion;
    private BigDecimal ventaFactura;
    private BigDecimal montoFlete;
    private Long numeroClientes;
  private BigDecimal saldoCC;
  private Long oidModulo;

    //agregado por Sapaza (03-07-2007), incidencia SiCC-20070309
    private Integer flagDevolucion;

    public DTOINTBoletasDespacho() {
    }

    public String getAnioCampania() {
        return anioCampania;
    }

    public void setAnioCampania(String anioCampania) {
        this.anioCampania = anioCampania;
    }

    public String getCodigoCanal() {
        return codigoCanal;
    }

    public void setCodigoCanal(String codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public Long getNumDocumentoFacturacion() {
        return numDocumentoFacturacion;
    }

    public void setNumDocumentoFacturacion(Long numDocumentoFacturacion) {
        this.numDocumentoFacturacion = numDocumentoFacturacion;
    }

    public Long getCodigoTerritorio() {
        return codigoTerritorio;
    }

    public void setCodigoTerritorio(Long codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }

    public String getCodigoConsultora() {
        return codigoConsultora;
    }

    public void setCodigoConsultora(String codigoConsultora) {
        this.codigoConsultora = codigoConsultora;
    }

    public Long getOidConsultora() {
        return oidConsultora;
    }

    public void setOidConsultora(Long oidConsultora) {
        this.oidConsultora = oidConsultora;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Long getOidClienteReceptor() {
        return oidClienteReceptor;
    }

    public void setOidClienteReceptor(Long oidClienteReceptor) {
        this.oidClienteReceptor = oidClienteReceptor;
    }

    public Integer getFlagAnulacion() {
        return flagAnulacion;
    }

    public void setFlagAnulacion(Integer flagAnulacion) {
        this.flagAnulacion = flagAnulacion;
    }

    public BigDecimal getVentaFactura() {
        return ventaFactura;
    }

    public void setVentaFactura(BigDecimal ventaFactura) {
        this.ventaFactura = ventaFactura;
    }

    public BigDecimal getMontoFlete() {
        return montoFlete;
    }

    public void setMontoFlete(BigDecimal montoFlete) {
        this.montoFlete = montoFlete;
    }

    public Long getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(Long numeroClientes) {
        this.numeroClientes = numeroClientes;
    }

  public BigDecimal getSaldoCC()
  {
    return saldoCC;
  }

  public void setSaldoCC(BigDecimal saldoCC)
  {
    this.saldoCC = saldoCC;
  }

  public Long getOidModulo()
  {
    return oidModulo;
  }

  public void setOidModulo(Long oidModulo)
  {
    this.oidModulo = oidModulo;
  }


  public void setFlagDevolucion(Integer flagDevolucion)
  {
    this.flagDevolucion = flagDevolucion;
  }


  public Integer getFlagDevolucion()
  {
    return flagDevolucion;
  }
}