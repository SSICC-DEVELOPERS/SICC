package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCargaMarcasTipoAbono extends DTOAuditableSICC {
  private RecordSet procesos;
  private RecordSet tiposAbono;
  private RecordSet marcasSituacion;

  public DTOCargaMarcasTipoAbono() {}

  public RecordSet getProcesos() {
    return procesos;
  }

  public void setProcesos(RecordSet newProcesos) {
    procesos = newProcesos;
  }

  public RecordSet getTiposAbono() {
    return tiposAbono;
  }

  public void setTiposAbono(RecordSet newTiposAbono) {
    tiposAbono = newTiposAbono;
  }

  public RecordSet getMarcasSituacion() {
    return marcasSituacion;
  }

  public void setMarcasSituacion(RecordSet newMarcasSituacion) {
    marcasSituacion = newMarcasSituacion;
  }  
}