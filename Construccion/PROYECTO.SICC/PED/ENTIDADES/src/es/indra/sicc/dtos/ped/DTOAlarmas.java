package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOAlarmas extends DTOAuditableSICC  {
  private Long numAlarmas;

  public DTOAlarmas() {
  }

  public Long getNumAlarmas() {
    return numAlarmas;
  }

  public void setNumAlarmas(Long newNumAlarmas) {
    numAlarmas = newNumAlarmas;
  }
}