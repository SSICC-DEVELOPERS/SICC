package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.*;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOListaDatosVariables extends DTOAuditableSICC {
  public DTOListaDatosVariables() {
  }

  private RecordSet datosVariables;

  public RecordSet getDatosVariables() {
    return datosVariables;
  }

  public void setDatosVariables(RecordSet newDatosVariables) {
    datosVariables = newDatosVariables;
  }
}