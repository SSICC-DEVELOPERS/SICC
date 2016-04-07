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
 
package es.indra.sicc.dtos.fac;
import es.indra.sicc.util.DTOBelcorp;

public class DTOTiposImpuestosUbigeo extends DTOBelcorp  {
  private Long canal;
  private Long acceso;
  private Long subacceso;
  private String ubigeo;
  private Long indicadorImpuesto;
  private Long oidValEstruGeopo;
  
  private Long oidTipoImpuestoUbigeo;//para modificacion
  private Boolean modificacion;//para modificacion

  public DTOTiposImpuestosUbigeo() {
  }

  public Long getCanal() {
    return canal;
  }

  public void setCanal(Long canal) {
    this.canal = canal;
  }

  public Long getAcceso() {
    return acceso;
  }

  public void setAcceso(Long acceso) {
    this.acceso = acceso;
  }

  public Long getSubacceso() {
    return subacceso;
  }

  public void setSubacceso(Long subacceso) {
    this.subacceso = subacceso;
  }

  public String getUbigeo() {
    return ubigeo;
  }

  public void setUbigeo(String ubigeo) {
    this.ubigeo = ubigeo;
  }

  public Long getIndicadorImpuesto() {
    return indicadorImpuesto;
  }

  public void setIndicadorImpuesto(Long indicadorImpuesto) {
    this.indicadorImpuesto = indicadorImpuesto;
  }

  public Long getOidValEstruGeopo() {
    return oidValEstruGeopo;
  }

  public void setOidValEstruGeopo(Long oidValEstruGeopo) {
    this.oidValEstruGeopo = oidValEstruGeopo;
  }

  public Long getOidTipoImpuestoUbigeo() {
    return oidTipoImpuestoUbigeo;
  }

  public void setOidTipoImpuestoUbigeo(Long oidTipoImpuestoUbigeo) {
    this.oidTipoImpuestoUbigeo = oidTipoImpuestoUbigeo;
  }

  public Boolean getModificacion() {
    return modificacion;
  }

  public void setModificacion(Boolean modificacion) {
    this.modificacion = modificacion;
  }
}