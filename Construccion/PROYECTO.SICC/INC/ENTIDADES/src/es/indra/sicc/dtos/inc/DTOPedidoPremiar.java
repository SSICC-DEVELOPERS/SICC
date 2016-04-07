package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOPedidoPremiar extends DTOBelcorp 
{
  private Long oidPedidoPremiar;
  private Integer numeroPedido;
  private Long oidNivelPremiacion;
  private BigDecimal exigenciaMinima;

  public Long getOidPedidoPremiar()
  {
    return oidPedidoPremiar;
  }

  public void setOidPedidoPremiar(Long oidPedidoPremiar)
  {
    this.oidPedidoPremiar = oidPedidoPremiar;
  }

  public Integer getNumeroPedido()
  {
    return numeroPedido;
  }

  public void setNumeroPedido(Integer numeroPedido)
  {
    this.numeroPedido = numeroPedido;
  }

  public Long getOidNivelPremiacion()
  {
    return oidNivelPremiacion;
  }

  public void setOidNivelPremiacion(Long oidNivelPremiacion)
  {
    this.oidNivelPremiacion = oidNivelPremiacion;
  }

  public BigDecimal getExigenciaMinima()
  {
    return exigenciaMinima;
  }

  public void setExigenciaMinima(BigDecimal exigenciaMinima)
  {
    this.exigenciaMinima = exigenciaMinima;
  }
}