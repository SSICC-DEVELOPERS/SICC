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
 *
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.dtos.intsys.DTOINT;

public class DTOINTRecepcionarClasificacion extends DTOINT {
  private Long modoEjecucion;
  private String pais;
  private String idioma;

  public DTOINTRecepcionarClasificacion() {
  }

  public Long getModoEjecucion() {
    return modoEjecucion;
  }

  public void setModoEjecucion(Long modoEjecucion) {
    this.modoEjecucion = modoEjecucion;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }
}