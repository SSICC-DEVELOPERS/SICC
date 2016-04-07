package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOFactoresConversion extends DTOSiccPaginacion  {

  Long oidFactoresConversion;
  BigDecimal factorConversion;
  Long oidMagnitud;
  Long oidUnidadMedidaOrigen;
  Long oidUnidadMedidaDestino;

  public DTOFactoresConversion() {
  }


  public void setOidFactoresConversion(Long oidFactoresConversion) {
    this.oidFactoresConversion = oidFactoresConversion;
  }


  public Long getOidFactoresConversion() {
    return oidFactoresConversion;
  }


  public void setFactorConversion(BigDecimal factorConversion) {
    this.factorConversion = factorConversion;
  }


  public BigDecimal getFactorConversion() {
    return factorConversion;
  }


  public void setOidMagnitud(Long oidMagnitud) {
    this.oidMagnitud = oidMagnitud;
  }


  public Long getOidMagnitud() {
    return oidMagnitud;
  }


  public void setOidUnidadMedidaOrigen(Long oidUnidadMedidaOrigen) {
    this.oidUnidadMedidaOrigen = oidUnidadMedidaOrigen;
  }


  public Long getOidUnidadMedidaOrigen() {
    return oidUnidadMedidaOrigen;
  }


  public void setOidUnidadMedidaDestino(Long oidUnidadMedidaDestino) {
    this.oidUnidadMedidaDestino = oidUnidadMedidaDestino;
  }


  public Long getOidUnidadMedidaDestino() {
    return oidUnidadMedidaDestino;
  }
}