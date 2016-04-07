package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOPosicionCambioVenta extends DTOAuditableSICC
{
  private Long oid;
  private Long oidProducto;
  private String codigoProducto;
  private String codigoVenta;
  private Long numeroPosicion;
  private Long unidadesAtendidas;
  private BigDecimal precioFacturaUnitarioLocal;
  private Long unidadesCambio;
  private Long unidadesVenta;
  private Integer numeroUnidad;
  private String userName;

  public DTOPosicionCambioVenta()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public String getCodigoProducto()
  {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto)
  {
    this.codigoProducto = codigoProducto;
  }

  public String getCodigoVenta()
  {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }

  public Long getNumeroPosicion()
  {
    return numeroPosicion;
  }

  public void setNumeroPosicion(Long numeroPosicion)
  {
    this.numeroPosicion = numeroPosicion;
  }

  public Long getUnidadesAtendidas()
  {
    return unidadesAtendidas;
  }

  public void setUnidadesAtendidas(Long unidadesAtendidas)
  {
    this.unidadesAtendidas = unidadesAtendidas;
  }

  public BigDecimal getPrecioFacturaUnitarioLocal()
  {
    return precioFacturaUnitarioLocal;
  }

  public void setPrecioFacturaUnitarioLocal(BigDecimal precioFacturaUnitarioLocal)
  {
    this.precioFacturaUnitarioLocal = precioFacturaUnitarioLocal;
  }

  public Long getUnidadesCambio()
  {
    return unidadesCambio;
  }

  public void setUnidadesCambio(Long unidadesCambio)
  {
    this.unidadesCambio = unidadesCambio;
  }

  public Long getUnidadesVenta()
  {
    return unidadesVenta;
  }

  public void setUnidadesVenta(Long unidadesVenta)
  {
    this.unidadesVenta = unidadesVenta;
  }

  public Integer getNumeroUnidad()
  {
    return numeroUnidad;
  }

  public void setNumeroUnidad(Integer numeroUnidad)
  {
    this.numeroUnidad = numeroUnidad;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}