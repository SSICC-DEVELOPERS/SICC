package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;

public class DTOCargarOrdenesDeCompra extends DTOAuditableSICC  {
  private String descripcion;
  private String indInterfaz;
  private Integer numeroLote;
  private String observaciones;
  private Date fechaOC;

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion) {
    descripcion = newDescripcion;
  }

  public String getIndInterfaz() {
    return indInterfaz;
  }

  public void setIndInterfaz(String newIndInterfaz) {
    indInterfaz = newIndInterfaz;
  }

  public Integer getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(Integer newNumeroLote) {
    numeroLote = newNumeroLote;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String newObservaciones) {
    observaciones = newObservaciones;
  }

  public Date getFechaOC() {
    return fechaOC;
  }

  public void setFechaOC(Date newFechaOC) {
    fechaOC = newFechaOC;
  }
}