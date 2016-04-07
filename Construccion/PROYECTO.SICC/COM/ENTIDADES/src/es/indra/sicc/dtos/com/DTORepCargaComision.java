package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORepCargaComision extends DTOAuditableSICC  {
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;
  private Long tipoComision;
  
  
  public DTORepCargaComision() {
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }
  
  public Long getTipoComision() {
    return tipoComision;
  }

  public void setTipoComision(Long tipoComision) {
    this.tipoComision = tipoComision;
  }
}