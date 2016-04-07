package es.indra.sicc.dtos.rec;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOFiltroBoletasRecojo extends DTOSiccPaginacion  {
  private Date fechaCaptura;
  private Long estado;
  private String idUsuario;

  public DTOFiltroBoletasRecojo() {
  }

  public Date getFechaCaptura() {
    return fechaCaptura;
  }

  public void setFechaCaptura(Date fechaCaptura) {
    this.fechaCaptura = fechaCaptura;
  }

  public Long getEstado() {
    return estado;
  }

  public void setEstado(Long estado) {
    this.estado = estado;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(String idUsuario) {
    this.idUsuario = idUsuario;
  }
}