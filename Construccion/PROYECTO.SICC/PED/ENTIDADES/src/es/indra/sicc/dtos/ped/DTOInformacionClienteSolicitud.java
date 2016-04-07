package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionClienteSolicitud extends DTOAuditableSICC {

    private Long oidTipoCliente;
    private Long oidSubtipocliente;
    private Long oidSubgerenciaVentas;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;
    private Long oidTerritorio;
            
    private Long oidCliente;
    private String codigoCliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipoCliente;
    private String subtipoCliente;
    private String subgerenciaCliente;
    private String regionCliente;
    private String zonaCliente;
    private String seccionCliente;
    private String territorioCliente;
    private String ubigeoCliente;

  public String getApellido1()
  {
    return apellido1;
  }

  public void setApellido1(String apellido1)
  {
    this.apellido1 = apellido1;
  }

  public String getApellido2()
  {
    return apellido2;
  }

  public void setApellido2(String apellido2)
  {
    this.apellido2 = apellido2;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getRegionCliente()
  {
    return regionCliente;
  }

  public void setRegionCliente(String regionCliente)
  {
    this.regionCliente = regionCliente;
  }

  public String getSeccionCliente()
  {
    return seccionCliente;
  }

  public void setSeccionCliente(String seccionCliente)
  {
    this.seccionCliente = seccionCliente;
  }

  public String getSubgerenciaCliente()
  {
    return subgerenciaCliente;
  }

  public void setSubgerenciaCliente(String subgerenciaCliente)
  {
    this.subgerenciaCliente = subgerenciaCliente;
  }

  public String getSubtipoCliente()
  {
    return subtipoCliente;
  }

  public void setSubtipoCliente(String subtipoCliente)
  {
    this.subtipoCliente = subtipoCliente;
  }

  public String getTerritorioCliente()
  {
    return territorioCliente;
  }

  public void setTerritorioCliente(String territorioCliente)
  {
    this.territorioCliente = territorioCliente;
  }

  public String getTipoCliente()
  {
    return tipoCliente;
  }

  public void setTipoCliente(String tipoCliente)
  {
    this.tipoCliente = tipoCliente;
  }

  public String getUbigeoCliente()
  {
    return ubigeoCliente;
  }

  public void setUbigeoCliente(String ubigeoCliente)
  {
    this.ubigeoCliente = ubigeoCliente;
  }

  public String getZonaCliente()
  {
    return zonaCliente;
  }

  public void setZonaCliente(String zonaCliente)
  {
    this.zonaCliente = zonaCliente;
  }


  public void setOidTipoCliente(Long oidTipoCliente)
  {
    this.oidTipoCliente = oidTipoCliente;
  }


  public Long getOidTipoCliente()
  {
    return oidTipoCliente;
  }


  public void setOidSubtipocliente(Long oidSubtipocliente)
  {
    this.oidSubtipocliente = oidSubtipocliente;
  }


  public Long getOidSubtipocliente()
  {
    return oidSubtipocliente;
  }


  public void setOidSubgerenciaVentas(Long oidSubgerenciaVentas)
  {
    this.oidSubgerenciaVentas = oidSubgerenciaVentas;
  }


  public Long getOidSubgerenciaVentas()
  {
    return oidSubgerenciaVentas;
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

}