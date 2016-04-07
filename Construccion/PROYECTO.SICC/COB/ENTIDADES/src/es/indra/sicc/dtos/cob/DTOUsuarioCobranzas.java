package es.indra.sicc.dtos.cob;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOUsuarioCobranzas extends DTOSiccPaginacion
{
  private Long oidUsuarioCobranza;
  private Long idUsuario;  
  private String nombre;
  private Long oidEstadoUsuario;
  private Long estadoAnterior;
  private Date fechaUltimoEstado;
  private Boolean indJefeCobranza;
  private Boolean indUsuarioSupervisor;
  private Boolean indUsuarioSupervisorAnterior;
  private Boolean indUsuarioExterno;  
  private String turnoHorarioEntrada;
  private String turnoHorarioSalida;
  private String codUsuario;
  private String codUsuarioSupervisor;
  private String codUsuarioRespaldo;
  private String observaciones;
  
  public DTOUsuarioCobranzas()
  {
  }


  public void setOidUsuarioCobranza(Long oidUsuarioCobranza)
  {
    this.oidUsuarioCobranza = oidUsuarioCobranza;
  }


  public Long getOidUsuarioCobranza()
  {
    return oidUsuarioCobranza;
  }


  public void setIdUsuario(Long idUsuario)
  {
    this.idUsuario = idUsuario;
  }


  public Long getIdUsuario()
  {
    return idUsuario;
  }


  public void setCodUsuario(String codUsuario)
  {
    this.codUsuario = codUsuario;
  }


  public String getCodUsuario()
  {
    return codUsuario;
  }


  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }


  public String getNombre()
  {
    return nombre;
  }


  public void setOidEstadoUsuario(Long oidEstadoUsuario)
  {
    this.oidEstadoUsuario = oidEstadoUsuario;
  }


  public Long getOidEstadoUsuario()
  {
    return oidEstadoUsuario;
  }


  public void setEstadoAnterior(Long estadoAnterior)
  {
    this.estadoAnterior = estadoAnterior;
  }


  public Long getEstadoAnterior()
  {
    return estadoAnterior;
  }


  public void setFechaUltimoEstado(Date fechaUltimoEstado)
  {
    this.fechaUltimoEstado = fechaUltimoEstado;
  }


  public Date getFechaUltimoEstado()
  {
    return fechaUltimoEstado;
  }


  public void setIndJefeCobranza(Boolean indJefeCobranza)
  {
    this.indJefeCobranza = indJefeCobranza;
  }


  public Boolean getIndJefeCobranza()
  {
    return indJefeCobranza;
  }


  public void setIndUsuarioSupervisor(Boolean indUsuarioSupervisor)
  {
    this.indUsuarioSupervisor = indUsuarioSupervisor;
  }


  public Boolean getIndUsuarioSupervisor()
  {
    return indUsuarioSupervisor;
  }


  public void setIndUsuarioExterno(Boolean indUsuarioExterno)
  {
    this.indUsuarioExterno = indUsuarioExterno;
  }


  public Boolean getIndUsuarioExterno()
  {
    return indUsuarioExterno;
  }


  public void setTurnoHorarioEntrada(String turnoHorarioEntrada)
  {
    this.turnoHorarioEntrada = turnoHorarioEntrada;
  }


  public String getTurnoHorarioEntrada()
  {
    return turnoHorarioEntrada;
  }


  public void setTurnoHorarioSalida(String turnoHorarioSalida)
  {
    this.turnoHorarioSalida = turnoHorarioSalida;
  }


  public String getTurnoHorarioSalida()
  {
    return turnoHorarioSalida;
  }


  public void setCodUsuarioSupervisor(String codUsuarioSupervisor)
  {
    this.codUsuarioSupervisor = codUsuarioSupervisor;
  }


  public String getCodUsuarioSupervisor()
  {
    return codUsuarioSupervisor;
  }


  public void setCodUsuarioRespaldo(String codUsuarioRespaldo)
  {
    this.codUsuarioRespaldo = codUsuarioRespaldo;
  }


  public String getCodUsuarioRespaldo()
  {
    return codUsuarioRespaldo;
  }


  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public String getObservaciones()
  {
    return observaciones;
  }


  public void setIndUsuarioSupervisorAnterior(Boolean indUsuarioSupervisorAnterior)
  {
    this.indUsuarioSupervisorAnterior = indUsuarioSupervisorAnterior;
  }


  public Boolean getIndUsuarioSupervisorAnterior()
  {
    return indUsuarioSupervisorAnterior;
  }

}