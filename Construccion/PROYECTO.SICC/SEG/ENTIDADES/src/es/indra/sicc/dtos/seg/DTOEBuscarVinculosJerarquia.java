package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarVinculosJerarquia extends DTOSiccPaginacion 
{
  private Long oidMarca;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidSubacceso;
  private Long oidEmpresa;

  public DTOEBuscarVinculosJerarquia()
  {
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca)
  {
    oidMarca = newOidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal)
  {
    oidCanal = newOidCanal;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso)
  {
    oidAcceso = newOidAcceso;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long newOidSubacceso)
  {
    oidSubacceso = newOidSubacceso;
  }

  public Long getOidEmpresa()
  {
    return oidEmpresa;
  }

  public void setOidEmpresa(Long newOidEmpresa)
  {
    oidEmpresa = newOidEmpresa;
  }
}