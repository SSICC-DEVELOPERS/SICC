package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOPeriodoDesdeHasta extends DTOBelcorp
{
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  
  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setPeriodoDesde(Long oidPeriodoDesde)
  {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }  
  
  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setPeriodoHasta(Long oidPeriodoHasta)
  {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }  
  
}



 
 
