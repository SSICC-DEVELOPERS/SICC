package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOObtenerUltimaFecha extends DTOAuditableSICC {
  private Long [] listaCriterios;
  private String codigoInterfaz;

  public Long [] getListaCriterios() {
    return listaCriterios;
  }

  public void setListaCriterios(Long [] listaCriterios) {
    this.listaCriterios = listaCriterios;
  }

  public String getCodigoInterfaz() {
    return codigoInterfaz;
  }

  public void setCodigoInterfaz(String codigoInterfaz) {
    this.codigoInterfaz = codigoInterfaz;
  }
  
}