package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOMantenimientoCaja extends DTOSiccPaginacion 
{
  private Long oidCaja;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidSubacceso;
  private String codigoCaja;
  private Long oidRespCierreCaja;
  private Long oidTipoCaja;
  private Long oidPais;

  public DTOMantenimientoCaja()
  {
  }


  public void setOidCaja(Long oidCaja)
  {
    this.oidCaja = oidCaja;
  }


  public Long getOidCaja()
  {
    return oidCaja;
  }


  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }


  public Long getOidCanal()
  {
    return oidCanal;
  }


  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }


  public Long getOidAcceso()
  {
    return oidAcceso;
  }


  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }


  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }


  public void setCodigoCaja(String codigoCaja)
  {
    this.codigoCaja = codigoCaja;
  }


  public String getCodigoCaja()
  {
    return codigoCaja;
  }


  public void setOidRespCierreCaja(Long oidRespCierreCaja)
  {
    this.oidRespCierreCaja = oidRespCierreCaja;
  }


  public Long getOidRespCierreCaja()
  {
    return oidRespCierreCaja;
  }


  public void setOidTipoCaja(Long oidTipoCaja)
  {
    this.oidTipoCaja = oidTipoCaja;
  }


  public Long getOidTipoCaja()
  {
    return oidTipoCaja;
  }


  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }


  public Long getOidPais()
  {
    return oidPais;
  }
  
  
}