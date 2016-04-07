package es.indra.sicc.dtos.car;
import es.indra.sicc.util.DTOBelcorp;

public class DTONivelRiesgo extends DTOBelcorp  {
  private Long oidCliente;
  private Long oidPeriodo;
  private Integer periodosReevaluar;
  private Integer periodoPedidos;
  private Integer numeroDiasDeudaVencida;
  private Integer numeroDiasAtraso;

  public DTONivelRiesgo() {
  }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }

  public Integer getPeriodosReevaluar() {
    return periodosReevaluar;
  }

  public void setPeriodosReevaluar(Integer periodosReevaluar) {
    this.periodosReevaluar = periodosReevaluar;
  }

  public Integer getPeriodoPedidos() {
    return periodoPedidos;
  }

  public void setPeriodoPedidos(Integer periodoPedidos) {
    this.periodoPedidos = periodoPedidos;
  }

  public Integer getNumeroDiasDeudaVencida() {
    return numeroDiasDeudaVencida;
  }

  public void setNumeroDiasDeudaVencida(Integer numeroDiasDeudaVencida) {
    this.numeroDiasDeudaVencida = numeroDiasDeudaVencida;
  }

  public Integer getNumeroDiasAtraso() {
    return numeroDiasAtraso;
  }

  public void setNumeroDiasAtraso(Integer numeroDiasAtraso) {
    this.numeroDiasAtraso = numeroDiasAtraso;
  }
}