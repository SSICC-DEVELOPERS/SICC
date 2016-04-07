package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * 
 * @author Cortaberria
 */
public class DTOContinuarFacturacion  extends DTOAuditableSICC {
  private Long oidConsolidado;
  private Boolean estado;

  public Long getOidConsolidado() {
    return oidConsolidado;
  }

  public void setOidConsolidado(Long oidConsolidado) {
    this.oidConsolidado = oidConsolidado;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }
}