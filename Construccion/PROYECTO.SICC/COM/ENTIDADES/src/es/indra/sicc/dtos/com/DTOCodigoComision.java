package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCodigoComision extends DTOAuditableSICC {
  private String codComision;

  public DTOCodigoComision() {  }
  
  public String getCodComision() {
    return this.codComision;
  }
  
  public void setCodComision(String newCodComision) {
    this.codComision = newCodComision;
  }
}