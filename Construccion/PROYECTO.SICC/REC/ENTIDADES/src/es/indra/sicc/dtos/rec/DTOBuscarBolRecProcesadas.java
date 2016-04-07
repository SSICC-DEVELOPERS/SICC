/**
 * Copyright 2008 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.rec;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarBolRecProcesadas  extends DTOSiccPaginacion  {
  private String fechaCaptura;
  private Long oidEstadoRecojo;
  private Integer validacion;
  private String usuario;
  private String orden;
  private String formatoFechaPais;

  public DTOBuscarBolRecProcesadas() {
  }

  public String getFechaCaptura() {
    return fechaCaptura;
  }

  public void setFechaCaptura(String fechaCaptura) {
    this.fechaCaptura = fechaCaptura;
  }

  public Long getOidEstadoRecojo() {
    return oidEstadoRecojo;
  }

  public void setOidEstadoRecojo(Long oidEstadoRecojo) {
    this.oidEstadoRecojo = oidEstadoRecojo;
  }

  public Integer getValidacion() {
    return validacion;
  }

  public void setValidacion(Integer validacion) {
    this.validacion = validacion;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }



  public String getOrden() {
    return orden;
  }

  public void setOrden(String orden) {
    this.orden = orden;
  }

  public String getFormatoFechaPais() {
    return formatoFechaPais;
  }

  public void setFormatoFechaPais(String formatoFecha) {
    this.formatoFechaPais = formatoFecha;
  }
}