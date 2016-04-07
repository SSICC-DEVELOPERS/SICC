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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion; 
import java.util.Vector;

public class DTOTipoBloqueo extends DTOSiccPaginacion 
{
  private Long oid;
  private String codigo;
  private String descripcion;
  private Vector attTraducible;
  private Boolean indBloqueoFinanciero;
  private Integer nivelGravedad;
  private Long oidMotivoRechazo;
  private Long oidValorAccionBloqueo;
  private Long oidValorAccionDesbloqueo;

  public DTOTipoBloqueo()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public Vector getAttTraducible()
  {
    return attTraducible;
  }

  public void setAttTraducible(Vector attTraducible)
  {
    this.attTraducible = attTraducible;
  }

  public Boolean getIndBloqueoFinanciero()
  {
    return indBloqueoFinanciero;
  }

  public void setIndBloqueoFinanciero(Boolean indBloqueoFinanciero)
  {
    this.indBloqueoFinanciero = indBloqueoFinanciero;
  }

  public Integer getNivelGravedad()
  {
    return nivelGravedad;
  }

  public void setNivelGravedad(Integer nivelGravedad)
  {
    this.nivelGravedad = nivelGravedad;
  }

  public Long getOidMotivoRechazo()
  {
    return oidMotivoRechazo;
  }

  public void setOidMotivoRechazo(Long oidMotivoRechazo)
  {
    this.oidMotivoRechazo = oidMotivoRechazo;
  }

  public Long getOidValorAccionBloqueo()
  {
    return oidValorAccionBloqueo;
  }

  public void setOidValorAccionBloqueo(Long oidValorAccionBloqueo)
  {
    this.oidValorAccionBloqueo = oidValorAccionBloqueo;
  }

  public Long getOidValorAccionDesbloqueo()
  {
    return oidValorAccionDesbloqueo;
  }

  public void setOidValorAccionDesbloqueo(Long oidValorAccionDesbloqueo)
  {
    this.oidValorAccionDesbloqueo = oidValorAccionDesbloqueo;
  }
}