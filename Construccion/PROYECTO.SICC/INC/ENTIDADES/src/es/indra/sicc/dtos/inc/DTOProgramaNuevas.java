package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOProgramaNuevas extends DTOBelcorp 
{
  private Long oidProgramaNuevas;
  private Integer periodosEvaluar;
  private Integer pedidosPremiar;
  private Long oidTipoExigencia;
  private Long oidTipoRequisito;
  private ArrayList listaPedidosPremiar;

  public Long getOidProgramaNuevas()
  {
    return oidProgramaNuevas;
  }

  public void setOidProgramaNuevas(Long oidProgramaNuevas)
  {
    this.oidProgramaNuevas = oidProgramaNuevas;
  }

  public Integer getPeriodosEvaluar()
  {
    return periodosEvaluar;
  }

  public void setPeriodosEvaluar(Integer periodosEvaluar)
  {
    this.periodosEvaluar = periodosEvaluar;
  }

  public Integer getPedidosPremiar()
  {
    return pedidosPremiar;
  }

  public void setPedidosPremiar(Integer pedidosPremiar)
  {
    this.pedidosPremiar = pedidosPremiar;
  }

  public Long getOidTipoExigencia()
  {
    return oidTipoExigencia;
  }

  public void setOidTipoExigencia(Long oidTipoExigencia)
  {
    this.oidTipoExigencia = oidTipoExigencia;
  }

  public Long getOidTipoRequisito()
  {
    return oidTipoRequisito;
  }

  public void setOidTipoRequisito(Long oidTipoRequisito)
  {
    this.oidTipoRequisito = oidTipoRequisito;
  }

  public ArrayList getListaPedidosPremiar()
  {
    return listaPedidosPremiar;
  }

  public void setListaPedidosPremiar(ArrayList listaPedidosPremiar)
  {
    this.listaPedidosPremiar = listaPedidosPremiar;
  }
}