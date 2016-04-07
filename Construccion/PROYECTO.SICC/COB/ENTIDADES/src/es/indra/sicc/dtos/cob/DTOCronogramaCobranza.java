package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class DTOCronogramaCobranza extends DTOAuditableSICC 
{
  Long oidCobranza;
  Long idCartera;
  Long oidEtapa;
  String codigoEtapaDeuda;
  Long oidPeriodo;
  String descripcionPeriodo;
  Long oidCanal;
  String descripcionCanal;
  Long oidMarca;
  String descripcionMarca;
  Long oidSubgerenciaVentas;
  String descripcionSubgerencia;
  Long oidRegion;
  String descripcionRegion;
  Long oidSeccion;
  String descripcionSeccion;
  Long oidZona;
  String descripcionZona;
  Long oidTerritorio;
  String descripcionTerritorio;
  Long oidUsuarioCobranza;
  String descripcionUsuarioCobranza;
  Long oidTipoCargo;
  String descripcionTipoCargo;
  Date fechaCierre;
  Date fechaEvaluacion;
  Date fechaAuditoria;
  String observaciones;
  Integer edadInicialEtapa;
  Integer edadFinalEtapa;
  Timestamp fechaFacturacion;
  BigDecimal importeAsignado;
  Boolean asignadoEnExceso;

  public DTOCronogramaCobranza()
  {
  }

  public Long getOidCobranza()
  {
    return oidCobranza;
  }

  public void setOidCobranza(Long oidCobranza)
  {
    this.oidCobranza = oidCobranza;
  }

  public Long getIdCartera()
  {
    return idCartera;
  }

  public void setIdCartera(Long idCartera)
  {
    this.idCartera = idCartera;
  }

  public Long getOidEtapa()
  {
    return oidEtapa;
  }

  public void setOidEtapa(Long oidEtapa)
  {
    this.oidEtapa = oidEtapa;
  }

  public String getCodigoEtapaDeuda()
  {
    return codigoEtapaDeuda;
  }

  public void setCodigoEtapaDeuda(String codigoEtapaDeuda)
  {
    this.codigoEtapaDeuda = codigoEtapaDeuda;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public String getDescripcionPeriodo()
  {
    return descripcionPeriodo;
  }

  public void setDescripcionPeriodo(String descripcionPeriodo)
  {
    this.descripcionPeriodo = descripcionPeriodo;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public String getDescripcionCanal()
  {
    return descripcionCanal;
  }

  public void setDescripcionCanal(String descripcionCanal)
  {
    this.descripcionCanal = descripcionCanal;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public String getDescripcionMarca()
  {
    return descripcionMarca;
  }

  public void setDescripcionMarca(String descripcionMarca)
  {
    this.descripcionMarca = descripcionMarca;
  }

  public Long getOidSubgerenciaVentas()
  {
    return oidSubgerenciaVentas;
  }

  public void setOidSubgerenciaVentas(Long oidSubgerenciaVentas)
  {
    this.oidSubgerenciaVentas = oidSubgerenciaVentas;
  }

  public String getDescripcionSubgerencia()
  {
    return descripcionSubgerencia;
  }

  public void setDescripcionSubgerencia(String descripcionSubgerencia)
  {
    this.descripcionSubgerencia = descripcionSubgerencia;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public String getDescripcionRegion()
  {
    return descripcionRegion;
  }

  public void setDescripcionRegion(String descripcionRegion)
  {
    this.descripcionRegion = descripcionRegion;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public String getDescripcionSeccion()
  {
    return descripcionSeccion;
  }

  public void setDescripcionSeccion(String descripcionSeccion)
  {
    this.descripcionSeccion = descripcionSeccion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public String getDescripcionZona()
  {
    return descripcionZona;
  }

  public void setDescripcionZona(String descripcionZona)
  {
    this.descripcionZona = descripcionZona;
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }

  public String getDescripcionTerritorio()
  {
    return descripcionTerritorio;
  }

  public void setDescripcionTerritorio(String descripcionTerritorio)
  {
    this.descripcionTerritorio = descripcionTerritorio;
  }

  public Long getOidUsuarioCobranza()
  {
    return oidUsuarioCobranza;
  }

  public void setOidUsuarioCobranza(Long oidUsuarioCobranza)
  {
    this.oidUsuarioCobranza = oidUsuarioCobranza;
  }

  public String getDescripcionUsuarioCobranza()
  {
    return descripcionUsuarioCobranza;
  }

  public void setDescripcionUsuarioCobranza(String descripcionUsuarioCobranza)
  {
    this.descripcionUsuarioCobranza = descripcionUsuarioCobranza;
  }

  public Long getOidTipoCargo()
  {
    return oidTipoCargo;
  }

  public void setOidTipoCargo(Long oidTipoCargo)
  {
    this.oidTipoCargo = oidTipoCargo;
  }

  public String getDescripcionTipoCargo()
  {
    return descripcionTipoCargo;
  }

  public void setDescripcionTipoCargo(String descripcionTipoCargo)
  {
    this.descripcionTipoCargo = descripcionTipoCargo;
  }

  public Date getFechaCierre()
  {
    return fechaCierre;
  }

  public void setFechaCierre(Date fechaCierre)
  {
    this.fechaCierre = fechaCierre;
  }

  public Date getFechaEvaluacion()
  {
    return fechaEvaluacion;
  }

  public void setFechaEvaluacion(Date fechaEvaluacion)
  {
    this.fechaEvaluacion = fechaEvaluacion;
  }

  public Date getFechaAuditoria()
  {
    return fechaAuditoria;
  }

  public void setFechaAuditoria(Date fechaAuditoria)
  {
    this.fechaAuditoria = fechaAuditoria;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Integer getEdadInicialEtapa()
  {
    return edadInicialEtapa;
  }

  public void setEdadInicialEtapa(Integer edadInicialEtapa)
  {
    this.edadInicialEtapa = edadInicialEtapa;
  }

  public Integer getEdadFinalEtapa()
  {
    return edadFinalEtapa;
  }

  public void setEdadFinalEtapa(Integer edadFinalEtapa)
  {
    this.edadFinalEtapa = edadFinalEtapa;
  }

  public Timestamp getFechaFacturacion()
  {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Timestamp fechaFacturacion)
  {
    this.fechaFacturacion = fechaFacturacion;
  }


   public void setImporteAsignado(BigDecimal importeAsignado) {
      this.importeAsignado = importeAsignado;
   }


   public BigDecimal getImporteAsignado() {
      return importeAsignado;
   }


   public void setAsignadoEnExceso(Boolean asignadoEnExceso) {
      this.asignadoEnExceso = asignadoEnExceso;
   }


   public Boolean getAsignadoEnExceso() {
      return asignadoEnExceso;
   }
}