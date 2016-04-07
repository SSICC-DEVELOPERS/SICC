package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOPremioPuntos extends DTOBelcorp {
  public Long oidPremioPuntos;
  public Integer numeroPremio;
  public Integer cantidad;
  public Long oidConcursoDestino;
  public Long oidTipoPremioPuntos;
  public BigDecimal porcentaje;

  public DTOPremioPuntos() {
  }

  public Long getOidPremioPuntos() {
    return oidPremioPuntos;
  }

  public void setOidPremioPuntos(Long oidPremioPuntos) {
    this.oidPremioPuntos = oidPremioPuntos;
  }

  public Integer getNumeroPremio() {
    return numeroPremio;
  }

  public void setNumeroPremio(Integer numeroPremio) {
    this.numeroPremio = numeroPremio;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Long getOidConcursoDestino() {
    return oidConcursoDestino;
  }

  public void setOidConcursoDestino(Long oidConcursoDestino) {
    this.oidConcursoDestino = oidConcursoDestino;
  }

  public Long getOidTipoPremioPuntos() {
    return oidTipoPremioPuntos;
  }

  public void setOidTipoPremioPuntos(Long oidTipoPremioPuntos) {
    this.oidTipoPremioPuntos = oidTipoPremioPuntos;
  }

  public BigDecimal getPorcentaje() {
    return porcentaje;
  }

  public void setPorcentaje(BigDecimal porcentaje) {
    this.porcentaje = porcentaje;
  }
}