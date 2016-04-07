package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOEINTIVR extends DTOBelcorp  {
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;
  private Long oidAcceso;
  private String numeroLote;
  private String descripcionLote;
  private String observaciones;
  private Boolean novedad;

  public DTOEINTIVR() {
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso) {
    this.oidAcceso = oidAcceso;
  }

  public String getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(String numeroLote) {
    this.numeroLote = numeroLote;
  }

  public String getDescripcionLote() {
    return descripcionLote;
  }

  public void setDescripcionLote(String descripcionLote) {
    this.descripcionLote = descripcionLote;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public Boolean getNovedad() {
    return novedad;
  }

  public void setNovedad(Boolean novedad) {
    this.novedad = novedad;
  }
}
