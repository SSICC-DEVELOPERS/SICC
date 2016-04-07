package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOGenerarFicheroDeEnviarConsultoras extends DTOAuditableSICC {
  private Long numeroLote;
  private String descripcion;
  private String observaciones;

  public DTOGenerarFicheroDeEnviarConsultoras() {
  }

  public Long getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(Long newNumeroLote) {
    numeroLote = newNumeroLote;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion) {
    descripcion = newDescripcion;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String newObservaciones) {
    observaciones = newObservaciones;
  }
}