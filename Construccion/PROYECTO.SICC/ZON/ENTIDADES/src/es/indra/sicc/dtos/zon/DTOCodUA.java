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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.zon;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCodUA   extends DTOBelcorp {
  private Long oidUA;
  private String codUA;
  private String codUAPadre;
  private String jerarquia;

  public DTOCodUA() {
  }

  public Long getOidUA() {
    return oidUA;
  }

  public void setOidUA(Long oidUA) {
    this.oidUA = oidUA;
  }

  public String getCodUA() {
    return codUA;
  }

  public void setCodUA(String codUA) {
    this.codUA = codUA;
  }

  public String getCodUAPadre() {
    return codUAPadre;
  }

  public void setCodUAPadre(String codUAPadre) {
    this.codUAPadre = codUAPadre;
  }

  public String getJerarquia() {
    return jerarquia;
  }

  public void setJerarquia(String jerarquia) {
    this.jerarquia = jerarquia;
  }
}