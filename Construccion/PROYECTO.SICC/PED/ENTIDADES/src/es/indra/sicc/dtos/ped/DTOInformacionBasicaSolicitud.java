package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionBasicaSolicitud extends DTOAuditableSICC {

    private Long oidSubacceso;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidPeriodo;
    private Long oidAcceso;
    
    private String tipoSolicitud;
    private Long oidTipoSolicitud;
    private String subacceso;
    private Long numeroSolicitud;
    private String marca;
    private String canal;
    private String periodo;
    private String acceso;
    private Long oidAccesoFisico;
    private Long oidTipoDespacho;
    private String sociedadVentas; 
  private Long oidProceso;

  public String getAcceso()
  {
    return acceso;
  }

  public void setAcceso(String acceso)
  {
    this.acceso = acceso;
  }

  public String getCanal()
  {
    return canal;
  }

  public void setCanal(String canal)
  {
    this.canal = canal;
  }

  public String getMarca()
  {
    return marca;
  }

  public void setMarca(String marca)
  {
    this.marca = marca;
  }

  public Long getNumeroSolicitud()
  {
    return numeroSolicitud;
  }

  public void setNumeroSolicitud(Long numeroSolicitud)
  {
    this.numeroSolicitud = numeroSolicitud;
  }

  public Long getOidAccesoFisico()
  {
    return oidAccesoFisico;
  }

  public void setOidAccesoFisico(Long oidAccesoFisico)
  {
    this.oidAccesoFisico = oidAccesoFisico;
  }

  public Long getOidTipoDespacho()
  {
    return oidTipoDespacho;
  }

  public void setOidTipoDespacho(Long oidTipoDespacho)
  {
    this.oidTipoDespacho = oidTipoDespacho;
  }

  public String getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(String periodo)
  {
    this.periodo = periodo;
  }

  public String getSociedadVentas()
  {
    return sociedadVentas;
  }

  public void setSociedadVentas(String sociedadVentas)
  {
    this.sociedadVentas = sociedadVentas;
  }

  public String getSubacceso()
  {
    return subacceso;
  }

  public void setSubacceso(String subacceso)
  {
    this.subacceso = subacceso;
  }

  public String getTipoSolicitud()
  {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(String tipoSolicitud)
  {
    this.tipoSolicitud = tipoSolicitud;
  }


    public void setOidTipoSolicitud(Long oidTipoSolicitud) {
        this.oidTipoSolicitud = oidTipoSolicitud;
    }


    public Long getOidTipoSolicitud() {
        return oidTipoSolicitud;
    }

  public Long getOidProceso()
  {
    return oidProceso;
  }

  public void setOidProceso(Long oidProceso)
  {
    this.oidProceso = oidProceso;
  }


  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }


  public Long getOidSubacceso()
  {
    return oidSubacceso;
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


  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }


  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }


  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }


  public Long getOidAcceso()
  {
    return oidAcceso;
  }

}