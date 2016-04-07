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

public class DTOEstrategia extends DTOAuditableSICC 
{
  private String codigo;
  private Boolean cuadreGrupos;
  private Boolean cvDespachoAutomatico;
  private Boolean cvDigitable;
  private Boolean cvImprimible;
  private Boolean listaRanking;
  private Integer maxGrupos;
  private Integer maxGruposCondicionados;
  private Integer maxGruposCondicionantes;
  private Boolean modificableDespachoAutomatico;
  private Boolean modificableDigitable;
  private Boolean modificableImprimible;
  private Long oid;
  private Long oidTipoEstr;
  private Long oidTipoProd;

  public DTOEstrategia()
  {
  }

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String newCodigo)
  {
    codigo = newCodigo;
  }

  public Boolean getCuadreGrupos()
  {
    return cuadreGrupos;
  }

  public void setCuadreGrupos(Boolean newCuadreGrupos)
  {
    cuadreGrupos = newCuadreGrupos;
  }

  public Boolean getCvDespachoAutomatico()
  {
    return cvDespachoAutomatico;
  }

  public void setCvDespachoAutomatico(Boolean newCvDespachoAutomatico)
  {
    cvDespachoAutomatico = newCvDespachoAutomatico;
  }

  public Boolean getCvDigitable()
  {
    return cvDigitable;
  }

  public void setCvDigitable(Boolean newCvDigitable)
  {
    cvDigitable = newCvDigitable;
  }

  public Boolean getCvImprimible()
  {
    return cvImprimible;
  }

  public void setCvImprimible(Boolean newCvImprimible)
  {
    cvImprimible = newCvImprimible;
  }

  public Boolean getListaRanking()
  {
    return listaRanking;
  }

  public void setListaRanking(Boolean newListaRanking)
  {
    listaRanking = newListaRanking;
  }

  public Integer getMaxGrupos()
  {
    return maxGrupos;
  }

  public void setMaxGrupos(Integer newMaxGrupos)
  {
    maxGrupos = newMaxGrupos;
  }

  public Integer getMaxGruposCondicionados()
  {
    return maxGruposCondicionados;
  }

  public void setMaxGruposCondicionados(Integer newMaxGruposCondicionados)
  {
    maxGruposCondicionados = newMaxGruposCondicionados;
  }

  public Integer getMaxGruposCondicionantes()
  {
    return maxGruposCondicionantes;
  }

  public void setMaxGruposCondicionantes(Integer newMaxGruposCondicionantes)
  {
    maxGruposCondicionantes = newMaxGruposCondicionantes;
  }

  public Boolean getModificableDespachoAutomatico()
  {
    return modificableDespachoAutomatico;
  }

  public void setModificableDespachoAutomatico(Boolean newModificableDespachoAutomatico)
  {
    modificableDespachoAutomatico = newModificableDespachoAutomatico;
  }

  public Boolean getModificableDigitable()
  {
    return modificableDigitable;
  }

  public void setModificableDigitable(Boolean newModificableDigitable)
  {
    modificableDigitable = newModificableDigitable;
  }

  public Boolean getModificableImprimible()
  {
    return modificableImprimible;
  }

  public void setModificableImprimible(Boolean newModificableImprimible)
  {
    modificableImprimible = newModificableImprimible;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long newOid)
  {
    oid = newOid;
  }

  public Long getOidTipoEstr()
  {
    return oidTipoEstr;
  }

  public void setOidTipoEstr(Long newOidTipoEstr)
  {
    oidTipoEstr = newOidTipoEstr;
  }

  public Long getOidTipoProd()
  {
    return oidTipoProd;
  }

  public void setOidTipoProd(Long newOidTipoProd)
  {
    oidTipoProd = newOidTipoProd;
  }
}