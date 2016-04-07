package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOUACliente extends DTOBelcorp
{
    private Long oidCliente; 
    private Long oidSubgerencia; 
    private Long oidRegion; 
    private Long oidZona; 
    private Long oidSeccion; 
    private Long oidTerritorio;

  public Long getOidCliente()
  {
    return oidCliente;
  }
  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }
  
  public Long getOidSubgerencia()
  {
    return oidSubgerencia;
  }
  public void setOidSubgerencia(Long oidSubgerencia)
  {
    this.oidSubgerencia = oidSubgerencia;
  }  
  
  public Long getOidRegion()
  {
    return oidRegion;
  }
  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }    
  
  public Long getOidZona()
  {
    return oidZona;
  }
  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }    
  
  public Long getOidSeccion()
  {
    return oidSeccion;
  }
  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }    
  
  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }
  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }    
  
}
