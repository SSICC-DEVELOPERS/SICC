package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOReasignacionPagos extends DTOBelcorp{

  private String codigoClienteReceptor;
  private Long oidClienteReceptor;
  private Long oidMovimientoOriginal;
  private String tipoTransaccion;
  private String observaciones;
  private Long numeroCupon;
  private Long numeroBoletaFactura;
  
  public DTOReasignacionPagos() {
    super();
  }


  public void setCodigoClienteReceptor(String codigoClienteReceptor) {
    this.codigoClienteReceptor = codigoClienteReceptor;
  }


  public String getCodigoClienteReceptor() {
    return codigoClienteReceptor;
  }


  public void setOidClienteReceptor(Long oidClienteReceptor) {
    this.oidClienteReceptor = oidClienteReceptor;
  }


  public Long getOidClienteReceptor() {
    return oidClienteReceptor;
  }


  public void setOidMovimientoOriginal(Long oidMovimientoOriginal) {
    this.oidMovimientoOriginal = oidMovimientoOriginal;
  }


  public Long getOidMovimientoOriginal() {
    return oidMovimientoOriginal;
  }


  public void setTipoTransaccion(String tipoTransaccion) {
    this.tipoTransaccion = tipoTransaccion;
  }


  public String getTipoTransaccion() {
    return tipoTransaccion;
  }


  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }


  public String getObservaciones() {
    return observaciones;
  }


  public void setNumeroCupon(Long numeroCupon){
    this.numeroCupon = numeroCupon;
  }


  public Long getNumeroCupon(){
    return numeroCupon;
  }


  public void setNumeroBoletaFactura(Long numeroBoletaFactura){
    this.numeroBoletaFactura = numeroBoletaFactura;
  }


  public Long getNumeroBoletaFactura() {
    return numeroBoletaFactura;
  }
}