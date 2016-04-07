package es.indra.sicc.dtos.ped;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOProductosMontoMinimo extends DTOBelcorp {
  private String codigoVenta;
  private Long oidProducto;
  private Long oidDetalleOferta;
  private BigDecimal precioUnitario;
  private BigDecimal impPrecioPosi;
  private Long oidFormaPago;
  private String descripcionProducto;

  public DTOProductosMontoMinimo() {
  }

  public String getCodigoVenta()
  {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public Long getOidDetalleOferta()
  {
    return oidDetalleOferta;
  }

  public void setOidDetalleOferta(Long oidDetalleOferta)
  {
    this.oidDetalleOferta = oidDetalleOferta;
  }

  public BigDecimal getPrecioUnitario()
  {
    return precioUnitario;
  }

  public void setPrecioUnitario(BigDecimal precioUnitario)
  {
    this.precioUnitario = precioUnitario;
  }

  public BigDecimal getImpPrecioPosi()
  {
    return impPrecioPosi;
  }

  public void setImpPrecioPosi(BigDecimal impPrecioPosi)
  {
    this.impPrecioPosi = impPrecioPosi;
  }

  public Long getOidFormaPago()
  {
    return oidFormaPago;
  }

  public void setOidFormaPago(Long oidFormaPago)
  {
    this.oidFormaPago = oidFormaPago;
  }

  public String getDescripcionProducto()
  {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String descripcionProducto)
  {
    this.descripcionProducto = descripcionProducto;
  }
  
}