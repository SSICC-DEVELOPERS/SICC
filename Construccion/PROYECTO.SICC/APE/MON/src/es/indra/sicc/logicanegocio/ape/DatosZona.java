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
 */
package es.indra.sicc.logicanegocio.ape;

public class DatosZona  {
  private Long oidSublinea;
  private Integer bahiaMayor;
  private Integer incremento;
  
  /* Agregados por BELC400000321 - dmorello, 25/04/2007 */
  private Integer maxBahiaPar;
  private Integer maxBahiaImpar;
  private Boolean frenteEspalda;
  /* Fin BELC400000321 dmorello 25/04/2007 */

  public DatosZona() {
  }

  public Long getOidSublinea() {
    return oidSublinea;
  }

  public void setOidSublinea(Long oidSublinea) {
    this.oidSublinea = oidSublinea;
  }

  public Integer getBahiaMayor() {
    return bahiaMayor;
  }

  public void setBahiaMayor(Integer bahiaMayor) {
    this.bahiaMayor = bahiaMayor;
  }

  public Integer getIncremento() {
    return incremento;
  }

  public void setIncremento(Integer incremento) {
    this.incremento = incremento;
  }

  public Integer getMaxBahiaPar()
  {
    return maxBahiaPar;
  }

  public void setMaxBahiaPar(Integer maxBahiaPar)
  {
    this.maxBahiaPar = maxBahiaPar;
  }

  public Integer getMaxBahiaImpar()
  {
    return maxBahiaImpar;
  }

  public void setMaxBahiaImpar(Integer maxBahiaImpar)
  {
    this.maxBahiaImpar = maxBahiaImpar;
  }

  public Boolean getFrenteEspalda()
  {
    return frenteEspalda;
  }

  public void setFrenteEspalda(Boolean frenteEspalda)
  {
    this.frenteEspalda = frenteEspalda;
  }
}