/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOMapaCentroDistribucionDetalle extends DTOBelcorp  {
  
  private Long oid;
  private String numeroAnaquel;
  private Long capacidad;
  private Boolean expandido;
  private DTOMapaCentroDistribucionCabecera mapaCentroDistribucionCabecera;
  private DTOSublineaArmado sublineaArmado;
  private DTOMapaCentroDistribucionDetalle anaquelDestino;
  
  public DTOMapaCentroDistribucionDetalle() { }
  
  public DTOMapaCentroDistribucionDetalle getAnaquelDestino() {
      return this.anaquelDestino;
  }
  
  public void setAnaquelDestino(DTOMapaCentroDistribucionDetalle anaquelDestino) {
      this.anaquelDestino = anaquelDestino;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setNumeroAnaquel(String numeroAnaquel) {
    this.numeroAnaquel = numeroAnaquel;
  }


  public String getNumeroAnaquel() {
    return numeroAnaquel;
  }


  public void setCapacidad(Long capacidad) {
    this.capacidad = capacidad;
  }


  public Long getCapacidad() {
    return capacidad;
  }


  public void setExpandido(Boolean expandido) {
    this.expandido = expandido;
  }


  public Boolean getExpandido() {
    return expandido;
  }


  public void setMapaCentroDistribucionCabecera(DTOMapaCentroDistribucionCabecera mapaCentroDistribucionCabecera) {
    this.mapaCentroDistribucionCabecera = mapaCentroDistribucionCabecera;
  }


  public DTOMapaCentroDistribucionCabecera getMapaCentroDistribucionCabecera() {
    return mapaCentroDistribucionCabecera;
  }


  public void setSublineaArmado(DTOSublineaArmado sublineaArmado) {
    this.sublineaArmado = sublineaArmado;
  }


  public DTOSublineaArmado getSublineaArmado() {
    return sublineaArmado;
  }
  
}