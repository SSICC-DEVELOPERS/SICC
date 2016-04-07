package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOMontoVentaRecomendadas extends DTOBelcorp 
{
  private Long oidMontoVenta;
  private Long oidTipoMontoVenta;
  private String descTipoMontoVenta;
  private BigDecimal cantidad;

  public Long getOidMontoVenta()
  {
    return oidMontoVenta;
  }

  public void setOidMontoVenta(Long oidMontoVenta)
  {
    this.oidMontoVenta = oidMontoVenta;
  }

  public Long getOidTipoMontoVenta()
  {
    return oidTipoMontoVenta;
  }

  public void setOidTipoMontoVenta(Long oidTipoMontoVenta)
  {
    this.oidTipoMontoVenta = oidTipoMontoVenta;
  }

  public String getDescTipoMontoVenta()
  {
    return descTipoMontoVenta;
  }

  public void setDescTipoMontoVenta(String descTipoMontoVenta)
  {
    this.descTipoMontoVenta = descTipoMontoVenta;
  }

  public BigDecimal getCantidad()
  {
    return cantidad;
  }
  
  public void setCantidad(BigDecimal cantidad){
    this.cantidad = cantidad;
  }
  
}