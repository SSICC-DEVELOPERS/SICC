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

import java.util.ArrayList;
import java.util.Vector;

public class DTOPlantilla extends DTOBelcorp
{
  public DTOPlantilla() {  }

  private Long oidPlantilla;
  private Integer numeroPlantilla;
  private ArrayList oidPaises;   
  private Long oidCanal;
  private ArrayList oidMarcas;
  private ArrayList oidAccesos;
  private Boolean indMultinivel;
  private Boolean indFaseCalificacion;
  private Long oidTipoCalificacion;
  private Boolean indIncremental;
  private Long oidDirigidoA;
  private Long oidBaseCalculo;
  private Boolean indProgramaNuevas;
  private Long oidTipoVenta;
  private Boolean indAmbitoGeografico;
  private Boolean indPartParticipantesCompleto;
  private Boolean indProductosValidos;
  private Boolean indProductosExcluidos;
  private Boolean indProductosExigidos;
  private Boolean indPremiosAcumuPorNiveles;
  private Boolean indNivelesRotativos;
  private Boolean indPremiosElectivos;
  private Boolean indPuntajeServicio;
  private Boolean indActiva;
  private Long oidTipoConcursoIVR;   
  private Vector attriTraducible;   
  Boolean indProductosBonificados;
  private String desCanal;
  private String desDirigidoA;
  private Boolean indBloqueado;
  
  // vbongiov -- Cambio 20080811 -- 26/08/2009
  private Boolean indSorteo;
  
  public Boolean getIndBloqueado() {
    return this.indBloqueado;    
  }
  
  public void setIndBloqueado(Boolean newIndBloqueado) {
    this.indBloqueado = newIndBloqueado;
  }
  
  public String getDesCanal()  {
    return this.desCanal;  
  }
  
  public void setDesCanal(String newDesCanal)  {
    this.desCanal = newDesCanal;
  }
  
  public String getDesDirigidoA() {
    return this.desDirigidoA;
  }
  
  public void setDesDirigidoA(String newDesDirigidoA)  {
    this.desDirigidoA = newDesDirigidoA;
  }

  public Vector getAttriTraducible()
  {
    return attriTraducible;
  }

  public void setAttriTraducible(Vector attriTraducible)
  {
    this.attriTraducible = attriTraducible;
  }

  public Boolean getIndActiva()
  {
    return indActiva;
  }

  public void setIndActiva(Boolean indActiva)
  {
    this.indActiva = indActiva;
  }

  public Boolean getIndAmbitoGeografico()
  {
    return indAmbitoGeografico;
  }

  public void setIndAmbitoGeografico(Boolean indAmbitoGeografico)
  {
    this.indAmbitoGeografico = indAmbitoGeografico;
  }

  public Boolean getIndFaseCalificacion()
  {
    return indFaseCalificacion;
  }

  public void setIndFaseCalificacion(Boolean indFaseCalificacion)
  {
    this.indFaseCalificacion = indFaseCalificacion;
  }

  public Boolean getIndIncremental()
  {
    return indIncremental;
  }

  public void setIndIncremental(Boolean indIncremental)
  {
    this.indIncremental = indIncremental;
  }

  public Boolean getIndMultinivel()
  {
    return indMultinivel;
  }

  public void setIndMultinivel(Boolean indMultinivel)
  {
    this.indMultinivel = indMultinivel;
  }

  public Boolean getIndNivelesRotativos()
  {
    return indNivelesRotativos;
  }

  public void setIndNivelesRotativos(Boolean indNivelesRotativos)
  {
    this.indNivelesRotativos = indNivelesRotativos;
  }

  public Boolean getIndPartParticipantesCompleto()
  {
    return indPartParticipantesCompleto;
  }

  public void setIndPartParticipantesCompleto(Boolean indPartParticipantesCompleto)
  {
    this.indPartParticipantesCompleto = indPartParticipantesCompleto;
  }

  public Boolean getIndPremiosAcumuPorNiveles()
  {
    return indPremiosAcumuPorNiveles;
  }

  public void setIndPremiosAcumuPorNiveles(Boolean indPremiosAcumuPorNiveles)
  {
    this.indPremiosAcumuPorNiveles = indPremiosAcumuPorNiveles;
  }

  public Boolean getIndPremiosElectivos()
  {
    return indPremiosElectivos;
  }

  public void setIndPremiosElectivos(Boolean indPremiosElectivos)
  {
    this.indPremiosElectivos = indPremiosElectivos;
  }

  public Boolean getIndProductosExcluidos()
  {
    return indProductosExcluidos;
  }

  public void setIndProductosExcluidos(Boolean indProductosExcluidos)
  {
    this.indProductosExcluidos = indProductosExcluidos;
  }

  public Boolean getIndProductosExigidos()
  {
    return indProductosExigidos;
  }

  public void setIndProductosExigidos(Boolean indProductosExigidos)
  {
    this.indProductosExigidos = indProductosExigidos;
  }

  public Boolean getIndProductosValidos()
  {
    return indProductosValidos;
  }

  public void setIndProductosValidos(Boolean indProductosValidos)
  {
    this.indProductosValidos = indProductosValidos;
  }

  public Boolean getIndProgramaNuevas()
  {
    return indProgramaNuevas;
  }

  public void setIndProgramaNuevas(Boolean indProgramaNuevas)
  {
    this.indProgramaNuevas = indProgramaNuevas;
  }

  public Boolean getIndPuntajeServicio()
  {
    return indPuntajeServicio;
  }

  public void setIndPuntajeServicio(Boolean indPuntajeServicio)
  {
    this.indPuntajeServicio = indPuntajeServicio;
  }

  public Integer getNumeroPlantilla()
  {
    return numeroPlantilla;
  }

  public void setNumeroPlantilla(Integer numeroPlantilla)
  {
    this.numeroPlantilla = numeroPlantilla;
  }

  public ArrayList getOidAccesos()
  {
    return oidAccesos;
  }

  public void setOidAccesos(ArrayList oidAccesos)
  {
    this.oidAccesos = oidAccesos;
  }

  public Long getOidBaseCalculo()
  {
    return oidBaseCalculo;
  }

  public void setOidBaseCalculo(Long oidBaseCalculo)
  {
    this.oidBaseCalculo = oidBaseCalculo;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidDirigidoA()
  {
    return oidDirigidoA;
  }

  public void setOidDirigidoA(Long oidDirigidoA)
  {
    this.oidDirigidoA = oidDirigidoA;
  }

  public ArrayList getOidMarcas()
  {
    return oidMarcas;
  }

  public void setOidMarcas(ArrayList oidMarcas)
  {
    this.oidMarcas = oidMarcas;
  }

  public ArrayList getOidPaises()
  {
    return oidPaises;
  }

  public void setOidPaises(ArrayList oidPaises)
  {
    this.oidPaises = oidPaises;
  }

  public Long getOidPlantilla()
  {
    return oidPlantilla;
  }

  public void setOidPlantilla(Long oidPlantilla)
  {
    this.oidPlantilla = oidPlantilla;
  }

  public Long getOidTipoCalificacion()
  {
    return oidTipoCalificacion;
  }

  public void setOidTipoCalificacion(Long oidTipoCalificacion)
  {
    this.oidTipoCalificacion = oidTipoCalificacion;
  }

  public Long getOidTipoConcursoIVR()
  {
    return oidTipoConcursoIVR;
  }

  public void setOidTipoConcursoIVR(Long oidTipoConcursoIVR)
  {
    this.oidTipoConcursoIVR = oidTipoConcursoIVR;
  }

  public Long getOidTipoVenta()
  {
    return oidTipoVenta;
  }

  public void setOidTipoVenta(Long oidTipoVenta)
  {
    this.oidTipoVenta = oidTipoVenta;
  }

  public Boolean getIndProductosBonificados()
  {
    return indProductosBonificados;
  }

  public void setIndProductosBonificados(Boolean indProductosBonificados)
  {
    this.indProductosBonificados = indProductosBonificados;
  }
  
  public Boolean getIndSorteo() {
    return this.indSorteo;    
  }
    
  public void setIndSorteo(Boolean newIndSorteo) {
    this.indSorteo = newIndSorteo;
  }
  
}