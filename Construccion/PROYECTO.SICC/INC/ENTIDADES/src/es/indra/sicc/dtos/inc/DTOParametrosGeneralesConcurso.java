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
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

import java.util.Vector;
import java.util.ArrayList;

public class DTOParametrosGeneralesConcurso extends DTOBelcorp
{
  private Long oid;
  private Long oidFicticio;
  private Long oidMarca;
  private Long oidCanal;
  private String desCanal;
  private ArrayList lstAccesos;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Boolean indDevoluciones;
  private Boolean indAnulaciones;
  private Boolean indFaltantesNoAnunciados;
  private String dirigidoA;
  private Long oidDirigidoA;
  private String expresionPuntaje;
  private Boolean indPruebas;
  private String observaciones;
  private Long oidTipoConcursoIVR;
  private Long oidPlantilla;
  private Boolean indActivo;
  private Boolean indRanking;
  private DTODatosGeneralesConcursoRanking datosGeneralesRanking;
  private String nombreConcurso;
    private Long oidPeriodoEntradaVigor;
    private Long oidVigenciaConcurso;
    private String codPeriodoDesde;
    private String codPeriodoHasta;
    
    //jrivas 25/1/2007 Cambio Dupla Cizone
    private Boolean indDuplaCyzone;
    
    //cvalenzu - fac-003
    private Long oidTipoPrograma;
    
    // vbongiov -- Cambio 20080809 -- 7/04/2009
    private Boolean indNoGeneraPunt;
    
    // vbongiov -- Cambio 20090930 -- 16/07/2009
     private Long oidClasificacionConcurso;

    // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
    private Long oidTipoOfertaConcurso;
    
    // sapaza -- PER-SICC-2012-0082 -- 16/05/2012
    private Boolean indMultiMarca;
    private Long puntosAbonar;

    
  public DTOParametrosGeneralesConcurso()
  {
  }
  
  public Long getOidTipoPrograma() {
	return oidTipoPrograma;
  }
    
  public void setOidTipoPrograma(Long oidTipoPrograma) {
    this.oidTipoPrograma = oidTipoPrograma;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidFicticio(){
    return this.oidFicticio;
  }
  
  public void setOidFicticio(Long oidFicticio){
    this.oidFicticio = oidFicticio;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public String getDesCanal()
  {
    return desCanal;
  }

  public void setDesCanal(String desCanal)
  {
    this.desCanal = desCanal;
  }

  public ArrayList getLstAccesos()
  {
    return lstAccesos;
  }

  public void setLstAccesos(ArrayList lstAccesos)
  {
    this.lstAccesos = lstAccesos;
  }

  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long oidPeriodoDesde)
  {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }

  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long oidPeriodoHasta)
  {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }

  public Boolean getIndDevoluciones()
  {
    return indDevoluciones;
  }

  public void setIndDevoluciones(Boolean indDevoluciones)
  {
    this.indDevoluciones = indDevoluciones;
  }

  public Boolean getIndAnulaciones()
  {
    return indAnulaciones;
  }

  public void setIndAnulaciones(Boolean indAnulaciones)
  {
    this.indAnulaciones = indAnulaciones;
  }

  public Boolean getIndFaltantesNoAnunciados()
  {
    return indFaltantesNoAnunciados;
  }

  public void setIndFaltantesNoAnunciados(Boolean indFaltantesNoAnunciados)
  {
    this.indFaltantesNoAnunciados = indFaltantesNoAnunciados;
  }

  public String getDirigidoA()
  {
    return dirigidoA;
  }

  public void setDirigidoA(String dirigidoA)
  {
    this.dirigidoA = dirigidoA;
  }

  public Long getOidDirigidoA()
  {
    return oidDirigidoA;
  }

  public void setOidDirigidoA(Long oidDirigidoA)
  {
    this.oidDirigidoA = oidDirigidoA;
  }

  public String getExpresionPuntaje()
  {
    return expresionPuntaje;
  }

  public void setExpresionPuntaje(String expresionPuntaje)
  {
    this.expresionPuntaje = expresionPuntaje;
  }

  public Boolean getIndPruebas()
  {
    return indPruebas;
  }

  public void setIndPruebas(Boolean indPruebas)
  {
    this.indPruebas = indPruebas;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Long getOidTipoConcursoIVR()
  {
    return oidTipoConcursoIVR;
  }

  public void setOidTipoConcursoIVR(Long oidTipoConcursoIVR)
  {
    this.oidTipoConcursoIVR = oidTipoConcursoIVR;
  }

  public Long getOidPlantilla()
  {
    return oidPlantilla;
  }

  public void setOidPlantilla(Long oidPlantilla)
  {
    this.oidPlantilla = oidPlantilla;
  }
  
  public Boolean getIndActivo(){
    return this.indActivo;
  }
  
  public void setIndActivo(Boolean indActivo){
    this.indActivo = indActivo;
  }
  
  public Boolean getIndRanking(){
    return this.indRanking;
  }
  
  public void setIndRanking(Boolean indRanking){
    this.indRanking = indRanking;
  }
  
  public DTODatosGeneralesConcursoRanking getDatosGeneralesRanking(){
    return this.datosGeneralesRanking;
  }
  
  public void setDatosGeneralesRanking(DTODatosGeneralesConcursoRanking datosGeneralesRanking){
    this.datosGeneralesRanking = datosGeneralesRanking;
  }
  
  public String getNombreConcurso(){
    return this.nombreConcurso;
  }
  
  public void setNombreConcurso(String nombreConcurso){
    this.nombreConcurso = nombreConcurso;
  }

    public Long getOidPeriodoEntradaVigor()
    {
        return oidPeriodoEntradaVigor;
    }

    public void setOidPeriodoEntradaVigor(Long oidPeriodoEntradaVigor)
    {
        this.oidPeriodoEntradaVigor = oidPeriodoEntradaVigor;
    }

    public Long getOidVigenciaConcurso()
    {
        return oidVigenciaConcurso;
    }

    public void setOidVigenciaConcurso(Long oidVigenciaConcurso)
    {
        this.oidVigenciaConcurso = oidVigenciaConcurso;
    }

    public String getCodPeriodoDesde()
    {
        return codPeriodoDesde;
    }

    public void setCodPeriodoDesde(String codPeriodoDesde)
    {
        this.codPeriodoDesde = codPeriodoDesde;
    }

    public String getCodPeriodoHasta()
    {
        return codPeriodoHasta;
    }

    public void setCodPeriodoHasta(String codPeriodoHasta)
    {
        this.codPeriodoHasta = codPeriodoHasta;
    }

    public void setIndDuplaCyzone(Boolean indDuplaCyzone){
      this.indDuplaCyzone = indDuplaCyzone;
    }
    
    public Boolean getIndDuplaCyzone(){
      return this.indDuplaCyzone;
    }    
    
    public void setIndNoGeneraPunt(Boolean indNoGeneraPunt){
      this.indNoGeneraPunt = indNoGeneraPunt;
    }
    
    public Boolean getIndNoGeneraPunt(){
      return this.indNoGeneraPunt;
    }   
    
    public Long getOidClasificacionConcurso()
    {
        return oidClasificacionConcurso;
    }

    public void setOidClasificacionConcurso(Long oidClasificacionConcurso)
    {
        this.oidClasificacionConcurso = oidClasificacionConcurso;
    }

    public void setOidTipoOfertaConcurso(Long oidTipoOfertaConcurso) {
        this.oidTipoOfertaConcurso = oidTipoOfertaConcurso;
    }

    public Long getOidTipoOfertaConcurso() {
        return oidTipoOfertaConcurso;
    }

    public void setIndMultiMarca(Boolean indMultiMarca) {
        this.indMultiMarca = indMultiMarca;
    }

    public Boolean getIndMultiMarca() {
        return indMultiMarca;
    }

    public void setPuntosAbonar(Long puntosAbonar) {
        this.puntosAbonar = puntosAbonar;
    }

    public Long getPuntosAbonar() {
        return puntosAbonar;
    }
}
