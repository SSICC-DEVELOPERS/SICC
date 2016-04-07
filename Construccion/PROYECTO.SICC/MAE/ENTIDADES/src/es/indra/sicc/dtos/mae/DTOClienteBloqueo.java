/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.dtos.mae;
import es.indra.sicc.util.DTOBelcorp;
import java.sql.Timestamp;

public class DTOClienteBloqueo extends DTOBelcorp 
{
  private Long oid;
  private Long oidCliente;
  private Long oidTipoBloqueo;
  private Timestamp fechaBloqueo;
  private String motivoBloqueo;
  private String usuarioBloqueo;
  private String observacionesBloqueo;
  private Timestamp fechaDesbloqueo;
  private String usuarioDesbloqueo;
  private Long oidFormaBloqueo;
  private Long oidFormaDesbloqueo;
  private String observacionesDesbloqueo;
  private Boolean indDesbloqueo;
  private String codFormaBloqueo;
  private String codFormaDesbloqueo;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidTipoBloqueo()
  {
    return oidTipoBloqueo;
  }

  public void setOidTipoBloqueo(Long oidTipoBloqueo)
  {
    this.oidTipoBloqueo = oidTipoBloqueo;
  }

  public Timestamp getFechaBloqueo()
  {
    return fechaBloqueo;
  }

  public void setFechaBloqueo(Timestamp fechaBloqueo)
  {
    this.fechaBloqueo = fechaBloqueo;
  }

  public String getMotivoBloqueo()
  {
    return motivoBloqueo;
  }

  public void setMotivoBloqueo(String motivoBloqueo)
  {
    this.motivoBloqueo = motivoBloqueo;
  }

  public String getUsuarioBloqueo()
  {
    return usuarioBloqueo;
  }

  public void setUsuarioBloqueo(String usuarioBloqueo)
  {
    this.usuarioBloqueo = usuarioBloqueo;
  }

  public String getObservacionesBloqueo()
  {
    return observacionesBloqueo;
  }

  public void setObservacionesBloqueo(String observacionesBloqueo)
  {
    this.observacionesBloqueo = observacionesBloqueo;
  }

  public Timestamp getFechaDesbloqueo()
  {
    return fechaDesbloqueo;
  }

  public void setFechaDesbloqueo(Timestamp fechaDesbloqueo)
  {
    this.fechaDesbloqueo = fechaDesbloqueo;
  }

  public String getUsuarioDesbloqueo()
  {
    return usuarioDesbloqueo;
  }

  public void setUsuarioDesbloqueo(String usuarioDesbloqueo)
  {
    this.usuarioDesbloqueo = usuarioDesbloqueo;
  }

  public Long getOidFormaBloqueo()
  {
    return oidFormaBloqueo;
  }

  public void setOidFormaBloqueo(Long oidFormaBloqueo)
  {
    this.oidFormaBloqueo = oidFormaBloqueo;
  }

  public Long getOidFormaDesbloqueo()
  {
    return oidFormaDesbloqueo;
  }

  public void setOidFormaDesbloqueo(Long oidFormaDesbloqueo)
  {
    this.oidFormaDesbloqueo = oidFormaDesbloqueo;
  }

  public String getObservacionesDesbloqueo()
  {
    return observacionesDesbloqueo;
  }

  public void setObservacionesDesbloqueo(String observacionesDesbloqueo)
  {
    this.observacionesDesbloqueo = observacionesDesbloqueo;
  }

  public Boolean getIndDesbloqueo()
  {
    return indDesbloqueo;
  }

  public void setIndDesbloqueo(Boolean indDesbloqueo)
  {
    this.indDesbloqueo = indDesbloqueo;
  }

  public String getCodFormaBloqueo()
  {
    return codFormaBloqueo;
  }

  public void setCodFormaBloqueo(String codFormaBloqueo)
  {
    this.codFormaBloqueo = codFormaBloqueo;
  }

  public String getCodFormaDesbloqueo()
  {
    return codFormaDesbloqueo;
  }

  public void setCodFormaDesbloqueo(String codFormaDesbloqueo)
  {
    this.codFormaDesbloqueo = codFormaDesbloqueo;
  }
}