package es.indra.sicc.cmn.negocio.interfaces;

import java.io.Serializable;

import java.util.Date;


/*
 * 16-05-2005 - rgiorgi: cambio por inc. 18257
 * */
public class InfoRegistroLote implements Serializable
{
  private Long pais;
  private String codigoInterfaz;
  private String numeroLote;
  private String descripcionLote;
  private Date fechaInicio;
  private Date fechaFin;
  private int numeroRegistrosProcesados;
  private int numeroRegistrosErroneos;
  private String observaciones;
  private String criteriosConsulta;
  private Long periodo;

  public InfoRegistroLote(  Long pais, String codigoInterfaz, String numeroLote, 
                            String descripcionLote, Date fechaInicio, Date fechaFin,
                            int numeroRegistrosProcesados, int numeroRegistrosErroneos, 
                            String observaciones, String criteriosConsulta)
  {
    this.pais = pais;
    this.codigoInterfaz = codigoInterfaz;
    this.numeroLote = numeroLote;
    this.descripcionLote = descripcionLote;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.numeroRegistrosProcesados = numeroRegistrosProcesados;
    this.numeroRegistrosErroneos = numeroRegistrosErroneos;
    this.observaciones = observaciones;
    this.criteriosConsulta = criteriosConsulta;
  }

  public Long getPais()
  {
    return pais;
  }

  public void setPais(Long pais)
  {
    this.pais = pais;
  }

  public String getCodigoInterfaz()
  {
    return codigoInterfaz;
  }

  public void setCodigoInterfaz(String codigoInterfaz)
  {
    this.codigoInterfaz = codigoInterfaz;
  }

  public String getNumeroLote()
  {
    return numeroLote;
  }

  public void setNumeroLote(String numeroLote)
  {
    this.numeroLote = numeroLote;
  }

  public String getDescripcionLote()
  {
    return descripcionLote;
  }

  public void setDescripcionLote(String descripcionLote)
  {
    this.descripcionLote = descripcionLote;
  }

  public Date getFechaInicio()
  {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio)
  {
    this.fechaInicio = fechaInicio;
  }

  public Date getFechaFin()
  {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin)
  {
    this.fechaFin = fechaFin;
  }

  public int getNumeroRegistrosProcesados()
  {
    return numeroRegistrosProcesados;
  }

  public void setNumeroRegistrosProcesados(int numeroRegistrosProcesados)
  {
    this.numeroRegistrosProcesados = numeroRegistrosProcesados;
  }

  public int getNumeroRegistrosErroneos()
  {
    return numeroRegistrosErroneos;
  }

  public void setNumeroRegistrosErroneos(int numeroRegistrosErroneos)
  {
    this.numeroRegistrosErroneos = numeroRegistrosErroneos;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

 public String getCriteriosConsulta()
  {
    return criteriosConsulta;
  }

  public void setCriteriosConsulta(String newCriteriosConsulta)
  {
    criteriosConsulta = newCriteriosConsulta;
  }  

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo)
  {
    this.periodo = newPeriodo;
  }  
}