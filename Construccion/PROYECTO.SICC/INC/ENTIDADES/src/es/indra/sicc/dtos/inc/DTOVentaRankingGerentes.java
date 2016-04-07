/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * 
 * @author Mariano Rodriguez
 * @fecha 20/07/2005
 */
public class DTOVentaRankingGerentes extends DTOSiccPaginacion{

    private Long oidConcurso;
    private Long oidNivelAgrupacion;
    private Long[] oidSGV;
    private Long[] oidRegion;
    private Long[] oidZona;
    private Long[] oidSeccion;
    private Long[] oidTerritorio;
    private Integer indIncurrencias;
    private Long oidTipoRanking;
  
    public void setOidConcurso(Long oidConcurso) {
      this.oidConcurso = oidConcurso;
    }
  
    public Long getOidConcurso() {
      return oidConcurso;
    }
  
    public void setOidNivelAgrupacion(Long oidNivelAgrupacion) {
      this.oidNivelAgrupacion = oidNivelAgrupacion;
    }
  
    public Long getOidNivelAgrupacion() {
      return oidNivelAgrupacion;
    }
  
    public void setOidSGV(Long[] oidSGV) {
      this.oidSGV = oidSGV;
    }
  
    public Long[] getOidSGV() {
      return oidSGV;
    }
  
    public void setOidRegion(Long[] oidRegion) {
      this.oidRegion = oidRegion;
    }
  
    public Long[] getOidRegion() {
      return oidRegion;
    }
  
    public void setOidZona(Long[] oidZona) {
      this.oidZona = oidZona;
    }
  
    public Long[] getOidZona() {
      return oidZona;
    }
  
    public void setOidSeccion(Long[] oidSeccion) {
      this.oidSeccion = oidSeccion;
    }
  
    public Long[] getOidSeccion() {
      return oidSeccion;
    }
  
    public void setOidTerritorio(Long[] oidTerritorio) {
      this.oidTerritorio = oidTerritorio;
    }
  
    public Long[] getOidTerritorio() {
      return oidTerritorio;
    }
  
    public void setIndIncurrencias(Integer indIncurrencias) {
      this.indIncurrencias = indIncurrencias;
    }
  
    public Integer getIndIncurrencias() {
      return indIncurrencias;
    }  


  public void setOidTipoRanking(Long oidTipoRanking)
  {
    this.oidTipoRanking = oidTipoRanking;
  }


  public Long getOidTipoRanking()
  {
    return oidTipoRanking;
  }

}