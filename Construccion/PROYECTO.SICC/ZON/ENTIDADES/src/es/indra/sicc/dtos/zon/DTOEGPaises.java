package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOEGPaises extends DTOAuditableSICC  {

  private RecordSet egp;

  public DTOEGPaises() {
  }

  public RecordSet getEgp()
  {
    return egp;
  }

  public void setEgp(RecordSet newEgp)
  {
    egp = newEgp;
  }
}