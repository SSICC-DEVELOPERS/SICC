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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOParametrosContables extends DTOSiccPaginacion{
  private Long oid;
	private Long cuenta;
	private Long subProceso;
	private Long proceso;
  private String indicativoDebeHaber;
  private String obtencionCuenta;
  private String textoApunte;
    
  private boolean concatenarFechaSN;
 
  public DTOParametrosContables() {
  }


  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setCuenta(Long cuenta) {
    this.cuenta = cuenta;
  }


  public Long getCuenta() {
    return cuenta;
  }


  public void setSubProceso(Long subProceso) {
    this.subProceso = subProceso;
  }


  public Long getSubProceso() {
    return subProceso;
  }


  public void setProceso(Long proceso) {
    this.proceso = proceso;
  }


  public Long getProceso() {
    return proceso;
  }

  public void setIndicativoDebeHaber(String indicativoDebeHaber) {
    this.indicativoDebeHaber = indicativoDebeHaber;
  }


  public String getIndicativoDebeHaber() {
    return indicativoDebeHaber;
  }


  public void setObtencionCuenta(String obtencionCuenta) {
    this.obtencionCuenta = obtencionCuenta;
  }


  public String getObtencionCuenta() {
    return obtencionCuenta;
  }


  public void setTextoApunte(String textoApunte) {
    this.textoApunte = textoApunte;
  }


  public String getTextoApunte() {
    return textoApunte;
  }

  public void setConcatenarFechaSN(boolean concatenarFechaSN) {
    this.concatenarFechaSN = concatenarFechaSN;
  }


  public boolean isConcatenarFechaSN() {
    return concatenarFechaSN;
  }

  public boolean getConcatenarFechaSN() {
    return concatenarFechaSN;
  }
  

}