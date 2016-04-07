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
 * Autor : Emilio Noziglia
 */
package es.indra.sicc.dtos.inc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
* Sistema:	Sicc Belcorp
* Modulo:	  INC 
* Fecha:		21/06/2005
* @version	1.0
* @autor		enozigli
*/
   
public class DTOVariablesVentaRankingConcurso extends DTOSiccPaginacion {

  private Long oid;
  private Long oidVariableVenta;
  private String variableVenta;
  private Boolean aplicable;
  private Integer peso;
  private Integer divisor;
  private Integer numeroDiasCobro;

  public DTOVariablesVentaRankingConcurso() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getOidVariableVenta() {
    return oidVariableVenta;
  }

  public void setOidVariableVenta(Long oidVariableVenta) {
    this.oidVariableVenta = oidVariableVenta;
  }

  public String getVariableVenta() {
    return variableVenta;
  }

  public void setVariableVenta(String variableVenta) {
    this.variableVenta = variableVenta;
  }

  public Boolean getAplicable() {
    return aplicable;
  }

  public void setAplicable(Boolean aplicable) {
    this.aplicable = aplicable;
  }

  public Integer getPeso() {
    return peso;
  }

  public void setPeso(Integer peso) {
    this.peso = peso;
  }

  public Integer getDivisor() {
    return divisor;
  }

  public void setDivisor(Integer divisor) {
    this.divisor = divisor;
  }

  public Integer getNumeroDiasCobro() {
    return numeroDiasCobro;
  }

  public void setNumeroDiasCobro(Integer numeroDiasCobro) {
    this.numeroDiasCobro = numeroDiasCobro;
  } 
  
}