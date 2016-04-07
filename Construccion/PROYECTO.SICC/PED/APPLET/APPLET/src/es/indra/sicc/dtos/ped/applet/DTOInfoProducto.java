package es.indra.sicc.dtos.ped.applet;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;

public class DTOInfoProducto extends DTOPaginacionClientePesado {
  private String codigoVenta;
  private String codigoProducto;
  private String descripcionProducto;
  private Long oidProducto;
  private Long oidMarca;
  private Long acceso;
  private Long subacceso;
  private Long periodo;
  private RecordSet listaProductos;
  private Long limiteVenta;
  private Long stockDisponible;
  private Boolean controlLiquidacion;
  private Long oidCliente;
  private Long oidZona;
  private String descripcionMarca;
  private Integer unidadesDemandadas;
  private Integer unidadesPorAtender;
  private Integer unidadesDemandaReal;
  private Integer cantidadReservar;
  private Long controlStock;
  private Long oidAlmacen;

  public DTOInfoProducto()
  {
  }

  public String getCodigoVenta()
  {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }

  public String getCodigoProducto()
  {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto)
  {
    this.codigoProducto = codigoProducto;
  }

  public String getDescripcionProducto()
  {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String descripcionProducto)
  {
    this.descripcionProducto = descripcionProducto;
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getAcceso()
  {
    return acceso;
  }

  public void setAcceso(Long acceso)
  {
    this.acceso = acceso;
  }

  public Long getSubacceso()
  {
    return subacceso;
  }

  public void setSubacceso(Long subacceso)
  {
    this.subacceso = subacceso;
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public RecordSet getListaProductos()
  {
    return listaProductos;
  }

  public void setListaProductos(RecordSet listaProductos)
  {
    this.listaProductos = listaProductos;
  }

  public Long getLimiteVenta()
  {
    return limiteVenta;
  }

  public void setLimiteVenta(Long limiteVenta)
  {
    this.limiteVenta = limiteVenta;
  }

  public Long getStockDisponible()
  {
    return stockDisponible;
  }

  public void setStockDisponible(Long stockDisponible)
  {
    this.stockDisponible = stockDisponible;
  }

  public Boolean getControlLiquidacion()
  {
    return controlLiquidacion;
  }

  public void setControlLiquidacion(Boolean controlLiquidacion)
  {
    this.controlLiquidacion = controlLiquidacion;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public String getDescripcionMarca()
  {
    return descripcionMarca;
  }

  public void setDescripcionMarca(String descripcionMarca)
  {
    this.descripcionMarca = descripcionMarca;
  }

  public Integer getUnidadesDemandadas()
  {
    return unidadesDemandadas;
  }

  public void setUnidadesDemandadas(Integer unidadesDemandadas)
  {
    this.unidadesDemandadas = unidadesDemandadas;
  }

  public Integer getUnidadesPorAtender()
  {
    return unidadesPorAtender;
  }

  public void setUnidadesPorAtender(Integer unidadesPorAtender)
  {
    this.unidadesPorAtender = unidadesPorAtender;
  }

  public Integer getUnidadesDemandaReal()
  {
    return unidadesDemandaReal;
  }

  public void setUnidadesDemandaReal(Integer unidadesDemandaReal)
  {
    this.unidadesDemandaReal = unidadesDemandaReal;
  }

  public Integer getCantidadReservar()
  {
    return cantidadReservar;
  }

  public void setCantidadReservar(Integer cantidadReservar)
  {
    this.cantidadReservar = cantidadReservar;
  }

  public Long getControlStock()
  {
    return controlStock;
  }

  public void setControlStock(Long controlStock)
  {
    this.controlStock = controlStock;
  }  

  public void setOidAlmacen(Long oidAlmacen)
  {
    this.oidAlmacen = oidAlmacen;
  }


  public Long getOidAlmacen()
  {
    return oidAlmacen;
  }
}