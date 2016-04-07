package es.indra.sicc.dtos.intsys;

public class DTOINTAsignacionAlmacen 
{
  public DTOINTAsignacionAlmacen()
  {
  }
  
    private Long  oid;          
    private Long  oidCanal;     
    private Long  oidAcceso;    
    private Long  oidSubacceso; 
    private Long  oidMarca;     
    private Long  oidAlmacen;   
    private Long  oidPais; 
    private Long  oidPeriodo;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidAlmacen()
  {
    return oidAlmacen;
  }

  public void setOidAlmacen(Long oidAlmacen)
  {
    this.oidAlmacen = oidAlmacen;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }


}