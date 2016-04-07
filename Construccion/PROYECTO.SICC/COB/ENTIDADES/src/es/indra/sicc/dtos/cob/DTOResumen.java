package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOResumen extends DTOSiccPaginacion
{
  public Long oidMarca;
  public Long oidCanal;
  public Long oidSGV;
  public Long oidRegion;
  public Long oidZona;
  public Long oidSeccion;
  public Long oidTerritorio;
  public Long oidEtapaDeuda;
  public Long oidTipoCargo;
  
  public DTOResumen()
  {
  }
  
  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }


  public Long getOidMarca()
  {
    return oidMarca;
  }


  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }


  public Long getOidCanal()
  {
    return oidCanal;
  }


  public void setOidSGV(Long oidSGV)
  {
    this.oidSGV = oidSGV;
  }


  public Long getOidSGV()
  {
    return oidSGV;
  }


  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }


  public Long getOidRegion()
  {
    return oidRegion;
  }


  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }


  public Long getOidZona()
  {
    return oidZona;
  }


  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }


  public Long getOidSeccion()
  {
    return oidSeccion;
  }


  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }


  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }


  public void setOidEtapaDeuda(Long oidEtapaDeuda)
  {
    this.oidEtapaDeuda = oidEtapaDeuda;
  }


  public Long getOidEtapaDeuda()
  {
    return oidEtapaDeuda;
  }


  public void setOidTipoCargo(Long oidTipoCargo)
  {
    this.oidTipoCargo = oidTipoCargo;
  }


  public Long getOidTipoCargo()
  {
    return oidTipoCargo;
  }
}