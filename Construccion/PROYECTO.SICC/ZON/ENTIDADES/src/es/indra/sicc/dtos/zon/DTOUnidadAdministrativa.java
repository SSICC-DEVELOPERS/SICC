package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUnidadAdministrativa extends DTOAuditableSICC {
  private Long oidPais;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidSGV;
  private Long oidRegion;
  private Long oidZona;
  private Long oidSeccion;
  private Long oidTerritorio;
  private String NSE1;
  private String NSE2;
  private String NSE3;
  private String descripcion;
  private Long oidTerritorioAdministrativo;
  private Long oidCliente;  
  
  //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365
  private String codUA;
    
  public DTOUnidadAdministrativa() { super(); }
  
  public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;      
  }
  
  public Long getOidCliente() {
    return this.oidCliente;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

  public Long getOidPais()
  {
    return this.oidPais;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidMarca()
  {
    return this.oidMarca;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidCanal()
  {
    return this.oidCanal;
  }  

  public void setOidSGV(Long oidSGV)
  {
    this.oidSGV = oidSGV;
  }

  public Long getOidSGV()
  {
    return this.oidSGV;
  }  
  
  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidRegion()
  {
    return this.oidRegion;
  }    

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidZona()
  {
    return this.oidZona;
  }    

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidSeccion()
  {
    return this.oidSeccion;
  }    

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }

  public Long getOidTerritorio()
  {
    return this.oidTerritorio;
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

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public String getDescripcion()
  {
    return this.descripcion;
  }      

  public void setOidTerritorioAdministrativo(Long oidTerritorioAdministrativo)
  {
    this.oidTerritorioAdministrativo = oidTerritorioAdministrativo;
  }

  public Long getOidTerritorioAdministrativo()
  {
    return this.oidTerritorioAdministrativo;
  }        


    public void setCodUA(String codUA)
    {
        this.codUA = codUA;
    }


    public String getCodUA()
    {
        return codUA;
    }
}