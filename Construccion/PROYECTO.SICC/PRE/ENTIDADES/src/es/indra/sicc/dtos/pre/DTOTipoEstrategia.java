/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipoEstrategia extends DTOAuditableSICC 
{
  private String codigoTipoEstrategia;
  private String descripcion;
  private Boolean estrategiaCondicionada;
  private Boolean estrategiaGrupo;
  private Boolean estrategiaPaquetes;
  private Boolean estrategiaVS;
  private Long oid;

  public DTOTipoEstrategia()
  {
  }

  public String getCodigoTipoEstrategia()
  {
    return codigoTipoEstrategia;
  }

  public void setCodigoTipoEstrategia(String newCodigoTipoEstrategia)
  {
    codigoTipoEstrategia = newCodigoTipoEstrategia;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion)
  {
    descripcion = newDescripcion;
  }

  public Boolean isEstrategiaCondicionada()
  {
    return estrategiaCondicionada;
  }
  
  public Boolean getEstrategiaCondicionada()
  {
    return estrategiaCondicionada;
  }

  public void setEstrategiaCondicionada(Boolean newEstrategiaCondicionada)
  {
    estrategiaCondicionada = newEstrategiaCondicionada;
  }

  public Boolean isEstrategiaGrupo()
  {
    return estrategiaGrupo;
  }

  public Boolean getEstrategiaGrupo()
  {
    return estrategiaGrupo;
  }

  public void setEstrategiaGrupo(Boolean newEstrategiaGrupo)
  {
    estrategiaGrupo = newEstrategiaGrupo;
  }

  public Boolean isEstrategiaPaquetes()
  {
    return estrategiaPaquetes;
  }

  public Boolean getEstrategiaPaquetes()
  {
    return estrategiaPaquetes;
  }

  public void setEstrategiaPaquetes(Boolean newEstrategiaPaquetes)
  {
    estrategiaPaquetes = newEstrategiaPaquetes;
  }

  public Boolean isEstrategiaVS()
  {
    return estrategiaVS;
  }
  
  public Boolean getEstrategiaVS()
  {
    return estrategiaVS;
  }

  public void setEstrategiaVS(Boolean newEstrategiaVS)
  {
    estrategiaVS = newEstrategiaVS;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long newOid)
  {
    oid = newOid;
  }
}