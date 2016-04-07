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

import es.indra.sicc.util.DTOSalida;
import java.util.Date;


public class DTOEntradaMatrizDias  extends  es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC{

  private String actividad;
  private Date fecha;
  private Long grupoZonas;
  private Long dias;
  private Long diasFinal;
  private Long diaIntervalo;
  private Boolean referenciada;
  private Long oid;
  private Long actividadOrigen;
  private String descActividadOrigen;
  private String descActividad;
    Long pais;
    Long marca;
    Long canal;
  private Long oidActividad;
  Integer diasRespectoActOrigen;

  public DTOEntradaMatrizDias() {
  }

  public Boolean isReferenciada() {
    return referenciada;
  }

  public void setReferenciada(Boolean newReferenciada) {
    referenciada = newReferenciada;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Long getGrupoZonas() {
    return grupoZonas;
  }

  public void setGrupoZonas(Long newGrupoZonas) {
    grupoZonas = newGrupoZonas;
  }

  public Long getDiasFinal() {
    return diasFinal;
  }

  public void setDiasFinal(Long newDiasFinal) {
    diasFinal = newDiasFinal;
  }

  public Long getDias() {
    return dias;
  }

  public void setDias(Long newDias) {
    dias = newDias;
  }

  public String getActividad() {
    return actividad;
  }

  public void setActividad(String newActividad) {
    actividad = newActividad;
  }

  public Long getDiaIntervalo() {
    return diaIntervalo;
  }

  public void setDiaIntervalo(Long newDiaIntervalo) {
    diaIntervalo = newDiaIntervalo;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date newFecha) {
    fecha = newFecha;
  }

  public Long getActividadOrigen() {
    return actividadOrigen;
  }

  public void setActividadOrigen(Long newActividadOrigen) {
    actividadOrigen = newActividadOrigen;
  }

  public String getDescActividad() {
    return descActividad;
  }

  public void setDescActividad(String newDescActividad) {
    descActividad = newDescActividad;
  }

  public Boolean getReferenciada(){
      return isReferenciada();
  }

  public String getDescActividadOrigen() {
    return descActividadOrigen;
  }

  public void setDescActividadOrigen(String newDescActividadOrigen) {
    descActividadOrigen = newDescActividadOrigen;
  }

    public Long getPais()
    {
        return pais;
    }

    public void setPais(Long newPais)
    {
        pais = newPais;
    }

    public Long getMarca()
    {
        return marca;
    }

    public void setMarca(Long newMarca)
    {
        marca = newMarca;
    }

    public Long getCanal()
    {
        return canal;
    }

    public void setCanal(Long newCanal)
    {
        canal = newCanal;
    }

  public Long getOidActividad() {
    return oidActividad;
  }

  public void setOidActividad(Long newOidActividad) {
    oidActividad = newOidActividad;
  }

  public Integer getDiasRespectoActOrigen() {
    return diasRespectoActOrigen;
  }

  public void setDiasRespectoActOrigen(Integer newDiasRespectoActOrigen) {
    diasRespectoActOrigen = newDiasRespectoActOrigen;
  }
  
}