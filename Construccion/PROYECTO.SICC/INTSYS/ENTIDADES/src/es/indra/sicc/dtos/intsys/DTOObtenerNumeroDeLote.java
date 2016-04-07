package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOObtenerNumeroDeLote extends DTOAuditableSICC {
  private String codInterfaz;

  public String getCodInterfaz() {
    return codInterfaz;
  }

  public void setCodInterfaz(String newCodInterfaz) {
    codInterfaz = newCodInterfaz;
  }
  
}