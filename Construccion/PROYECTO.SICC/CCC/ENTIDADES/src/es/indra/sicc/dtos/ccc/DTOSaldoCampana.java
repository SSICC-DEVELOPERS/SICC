package es.indra.sicc.dtos.ccc;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSaldoCampana extends DTOAuditableSICC  {
  private Long oidPeriodo;
  private Long oidCliente;
  private RecordSet saldoCampana;
  
  public DTOSaldoCampana() {
  }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }

  public RecordSet getSaldoCampana() {
    return saldoCampana;
  }

  public void setSaldoCampana(RecordSet saldoCampana) {
    this.saldoCampana = saldoCampana;
  }
}