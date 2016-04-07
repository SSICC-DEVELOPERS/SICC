package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUniNSE extends DTOAuditableSICC 
{
  private Long oidUni;
  private String NSE1;
  private String NSE2;
  private String NSE3;
  
  public DTOUniNSE()
  {
    super();
  }

  public void setOidUni(Long oiduni)
  {
    this.oidUni = oiduni;
  }

  public Long getOidUni()
  {
    return oidUni;
  }

  public void setNSE1(String NSE1)
  {
    this.NSE1 = NSE1;
  }

  public String getNSE1()
  {
    return this.NSE1;
  }

  public void setNSE2(String NSE2)
  {
    this.NSE2 = NSE2;
  }

  public String getNSE2()
  {
    return this.NSE2;
  }

  public void setNSE3(String NSE3)
  {
    this.NSE3 = NSE3;
  }

  public String getNSE3()
  {
    return this.NSE3;
  }  

  
}