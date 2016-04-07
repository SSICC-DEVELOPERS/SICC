package es.indra.sicc.dtos.ped.applet;

import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;

public class DTOBuscarProductosRegistro extends DTOPaginacionClientePesado {
  private Long oidAlmacen;
  private Long oidCatalogo;
  private Long pagina;
  private Long oidLineaProducto;
  private String descripcionLarga;
  private String descripcionCorta;
  private Long precioDesde;
  private Long precioHasta;
  private Long oidCabeceraSolicitud;
  private Long acceso;
  private Long subacceso;
  private Long periodo;
  private Long oidTipoSolicitud;

  public Long getOidAlmacen()
  {
    return oidAlmacen;
  }

  public void setOidAlmacen(Long oidAlmacen)
  {
    this.oidAlmacen = oidAlmacen;
  }

  public Long getOidCatalogo()
  {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long oidCatalogo)
  {
    this.oidCatalogo = oidCatalogo;
  }

  public Long getPagina()
  {
    return pagina;
  }

  public void setPagina(Long pagina)
  {
    this.pagina = pagina;
  }

  public Long getOidLineaProducto()
  {
    return oidLineaProducto;
  }

  public void setOidLineaProducto(Long oidLineaProducto)
  {
    this.oidLineaProducto = oidLineaProducto;
  }

  public String getDescripcionLarga()
  {
    return descripcionLarga;
  }

  public void setDescripcionLarga(String descripcionLarga)
  {
    this.descripcionLarga = descripcionLarga;
  }

  public String getDescripcionCorta()
  {
    return descripcionCorta;
  }

  public void setDescripcionCorta(String descripcionCorta)
  {
    this.descripcionCorta = descripcionCorta;
  }

  public Long getPrecioDesde()
  {
    return precioDesde;
  }

  public void setPrecioDesde(Long precioDesde)
  {
    this.precioDesde = precioDesde;
  }

  public Long getPrecioHasta()
  {
    return precioHasta;
  }

  public void setPrecioHasta(Long precioHasta)
  {
    this.precioHasta = precioHasta;
  }
  
  public Long getOidCabeceraSolicitud(){
    return oidCabeceraSolicitud;
  }
  
  public void setOidCabeceraSolicitud(Long oid){
    this.oidCabeceraSolicitud = oid;
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


    public void setOidTipoSolicitud(Long oidTipoSolicitud)
    {
        this.oidTipoSolicitud = oidTipoSolicitud;
    }


    public Long getOidTipoSolicitud()
    {
        return oidTipoSolicitud;
    }
  
}