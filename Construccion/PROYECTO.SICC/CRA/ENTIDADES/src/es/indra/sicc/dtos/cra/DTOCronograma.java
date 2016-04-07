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
 */
package es.indra.sicc.dtos.cra;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;

public class DTOCronograma extends DTOAuditableSICC  {
  private Long marca;
  private Long canal;
  //DTOGrupoCronograma[]
  private Vector grupos;  
  private Long periodo;
  private String codigoPeriodo;
  private Long tipoFacturacion;
  private Date ndff;
  private Integer ndm;
  private Date fechaIniPeriodo;
  private Integer diasPeriodo;
  private Date fechaFinPeriodo;
  private Boolean esZonas;
  private Long grupo;
  private Long subgerencia;
  private Long region;
  private Long zona;
  private Vector diasFacturacion;

  public DTOCronograma() {
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long newMarca) {
    marca = newMarca;
  }

  public Long getCanal() {
    return canal;
  }

  public void setCanal(Long newCanal) {
    canal = newCanal;
  }

  public Vector getGrupos() {
    return grupos;
  }

  public void setGrupos(Vector newGrupos) {
    grupos = newGrupos;
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo) {
    periodo = newPeriodo;
  }

  public String getCodigoPeriodo() {
    return codigoPeriodo;
  }

  public void setCodigoPeriodo(String newCodigoPeriodo) {
    codigoPeriodo = newCodigoPeriodo;
  }

  public Long getTipoFacturacion() {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(Long newTipoFacturacion) {
    tipoFacturacion = newTipoFacturacion;
  }

  public Date getNdff() {
    return ndff;
  }

  public void setNdff(Date newNdff) {
    ndff = newNdff;
  }

  public Integer getNdm() {
    return ndm;
  }

  public void setNdm(Integer newNdm) {
    ndm = newNdm;
  }

  public Date getFechaIniPeriodo() {
    return fechaIniPeriodo;
  }

  public void setFechaIniPeriodo(Date newFechaIniPeriodo) {
    fechaIniPeriodo = newFechaIniPeriodo;
  }

  public Integer getDiasPeriodo() {
    return diasPeriodo;
  }

  public void setDiasPeriodo(Integer newDiasPeriodo) {
    diasPeriodo = newDiasPeriodo;
  }

  public Date getFechaFinPeriodo() {
    return fechaFinPeriodo;
  }

  public void setFechaFinPeriodo(Date newFechaFinPeriodo) {
    fechaFinPeriodo = newFechaFinPeriodo;
  }

  public Boolean getEsZonas() {
    return esZonas;
  }

  public void setEsZonas(Boolean newEsZonas) {
    esZonas = newEsZonas;
  }

  public Long getGrupo() {
    return grupo;
  }

  public void setGrupo(Long newGrupo) {
    grupo = newGrupo;
  }

  public Long getSubgerencia() {
    return subgerencia;
  }

  public void setSubgerencia(Long newSubgerencia) {
    subgerencia = newSubgerencia;
  }

  public Long getRegion() {
    return region;
  }

  public void setRegion(Long newRegion) {
    region = newRegion;
  }

  public Long getZona() {
    return zona;
  }

  public void setZona(Long newZona) {
    zona = newZona;
  }

  public Vector getDiasFacturacion() {
    return diasFacturacion;
  }

  public void setDiasFacturacion(Vector newDiasFacturacion) {
    diasFacturacion = newDiasFacturacion;
  }
}