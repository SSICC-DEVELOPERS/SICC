package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOIncrementoPorRango extends DTOBelcorp 
{
  private Long oidRango;
  private BigDecimal desde;
  private BigDecimal hasta;
  private BigDecimal incremento;

  public Long getOidRango()
  {
    return oidRango;
  }

  public void setOidRango(Long oidRango)
  {
    this.oidRango = oidRango;
  }

  public BigDecimal getDesde()
  {
    return desde;
  }

  public void setDesde(BigDecimal desde)
  {
    this.desde = desde;
  }

  public BigDecimal getHasta()
  {
    return hasta;
  }

  public void setHasta(BigDecimal hasta)
  {
    this.hasta = hasta;
  }

  public BigDecimal getIncremento()
  {
    return incremento;
  }

  public void setIncremento(BigDecimal incremento)
  {
    this.incremento = incremento;
  }
}