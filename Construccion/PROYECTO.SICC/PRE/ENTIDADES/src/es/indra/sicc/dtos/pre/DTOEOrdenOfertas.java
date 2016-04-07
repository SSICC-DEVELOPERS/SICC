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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEOrdenOfertas extends DTOSiccPaginacion 
{
  private Long oidCabeceraMF;
  private Boolean mostrarImprimibles;
  private Long oidCatalogo;
  private Long oidTipoOferta;
  private Integer paginaDesde;
  private Integer paginaHasta;

  public DTOEOrdenOfertas()
  {
  }

  public Long getOidCabeceraMF()
  {
    return oidCabeceraMF;
  }

  public void setOidCabeceraMF(Long newOidCabeceraMF)
  {
    oidCabeceraMF = newOidCabeceraMF;
  }

  public Boolean getMostrarImprimibles()
  {
    return mostrarImprimibles;
  }

  public void setMostrarImprimibles(Boolean newMostrarImprimibles)
  {
    mostrarImprimibles = newMostrarImprimibles;
  }

  public Long getOidCatalogo() {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long oidCatalogo) {
    this.oidCatalogo = oidCatalogo;
  }

  public Long getOidTipoOferta() {
    return oidTipoOferta;
  }

  public void setOidTipoOferta(Long oidTipoOferta) {
    this.oidTipoOferta = oidTipoOferta;
  }

  public Integer getPaginaDesde() {
    return paginaDesde;
  }

  public void setPaginaDesde(Integer paginaDesde) {
    this.paginaDesde = paginaDesde;
  }

  public Integer getPaginaHasta() {
    return paginaHasta;
  }

  public void setPaginaHasta(Integer paginaHasta) {
    this.paginaHasta = paginaHasta;
  }
}