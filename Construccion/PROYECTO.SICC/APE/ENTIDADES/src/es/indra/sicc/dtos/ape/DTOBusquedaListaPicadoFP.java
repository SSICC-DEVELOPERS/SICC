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
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOBusquedaListaPicadoFP extends DTOSiccPaginacion  {
    private Long oidZona;
    private Long oidSeccion;
    private Long oidMarca;
    private Long oidCanal;
    private Date fechaArmado;
    private Long oidRegion;
    private Long oidConfiguracionCD;


  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }


  public Long getOidZona() {
    return oidZona;
  }


  public void setOidSeccion(Long oidSeccion) {
    this.oidSeccion = oidSeccion;
  }


  public Long getOidSeccion() {
    return oidSeccion;
  }


  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }


  public Long getOidMarca() {
    return oidMarca;
  }


  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }


  public Long getOidCanal() {
    return oidCanal;
  }


  public void setFechaArmado(Date fechaArmado) {
    this.fechaArmado = fechaArmado;
  }


  public Date getFechaArmado() {
    return fechaArmado;
  }


  public void setOidRegion(Long oidRegion) {
    this.oidRegion = oidRegion;
  }


  public Long getOidRegion() {
    return oidRegion;
  }


  public void setOidConfiguracionCD(Long oidConfiguracionCD) {
    this.oidConfiguracionCD = oidConfiguracionCD;
  }


  public Long getOidConfiguracionCD() {
    return oidConfiguracionCD;
  }
  
  
}