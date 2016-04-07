package es.indra.sicc.dtos.ped.applet;

import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;

public class DTOPresentarFlete extends DTOPaginacionClientePesado {
  private Long oidCliente;
  private Long oidPeriodo;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidTipoDespacho;
  private Boolean fleteZona;
  private Long oidZona;
  private Long oidUbigeo;
  private Long oidTipoCliente;
  private Long oidSubtipoCliente;

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidTipoDespacho()
  {
    return oidTipoDespacho;
  }

  public void setOidTipoDespacho(Long oidTipoDespacho)
  {
    this.oidTipoDespacho = oidTipoDespacho;
  }

  public Boolean getFleteZona()
  {
    return fleteZona;
  }

  public void setFleteZona(Boolean fleteZona)
  {
    this.fleteZona = fleteZona;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidUbigeo()
  {
    return oidUbigeo;
  }

  public void setOidUbigeo(Long oidUbigeo)
  {
    this.oidUbigeo = oidUbigeo;
  }

  public Long getOidTipoCliente()
  {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long oidTipoCliente)
  {
    this.oidTipoCliente = oidTipoCliente;
  }

  public Long getOidSubtipoCliente()
  {
    return oidSubtipoCliente;
  }

  public void setOidSubtipoCliente(Long oidSubtipoCliente)
  {
    this.oidSubtipoCliente = oidSubtipoCliente;
  }
}