package es.indra.sicc.dtos.intsys;

public class DTOINTCtaCteEmpresa 
{
  public DTOINTCtaCteEmpresa()
  {
  }
  
  private Long oidCtaCteBanc;
  private Long sociedad;


  public void setOidCtaCteBanc(Long oidCtaCteBanc)
  {
    this.oidCtaCteBanc = oidCtaCteBanc;
  }


  public Long getOidCtaCteBanc()
  {
    return oidCtaCteBanc;
  }


  public void setSociedad(Long sociedad)
  {
    this.sociedad = sociedad;
  }


  public Long getSociedad()
  {
    return sociedad;
  }
  
}