package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosMotivosAtencion extends DTOBelcorp  {
  private String motivoAtencion;
  private String descripcionMotivo;

  public DTODatosMotivosAtencion() {
  }

  public String getMotivoAtencion() {
    return motivoAtencion;
  }

  public void setMotivoAtencion(String motivoAtencion) {
    this.motivoAtencion = motivoAtencion;
  }

  public String getDescripcionMotivo() {
    return descripcionMotivo;
  }

  public void setDescripcionMotivo(String descripcionMotivo) {
    this.descripcionMotivo = descripcionMotivo;
  }
}
