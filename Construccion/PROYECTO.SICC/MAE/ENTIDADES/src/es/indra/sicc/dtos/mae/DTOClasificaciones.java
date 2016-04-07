package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOClasificaciones extends DTOAuditableSICC {
  
  private RecordSet clasificacion;
  private RecordSet tipoClasificacion;

  public DTOClasificaciones() {
  }
  
  public RecordSet getClasificacion() {
    return clasificacion;
  }

  public void setClasificacion(RecordSet newClasificacion) {
    clasificacion = newClasificacion;
  }

  public RecordSet getTipoClasificacion() {
    return tipoClasificacion;
  }

  public void setTipoClasificacion(RecordSet newTipoClasificacion) {
    tipoClasificacion = newTipoClasificacion;
  }
}