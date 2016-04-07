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

public class DTOActividadMatriz extends DTOAuditableSICC  {
    private Long actividad;
    private Long origen;
    private Long dia;
    private Long diasFinal;
    private Long diasIntervalo;
    private Long diaPeriodo;
    private Long oid;
    private Integer idVista;
    private String textoActividad;
    private Long grupo;
    private Boolean esMover;
    private String codigo;
    private String textoGrupo;
    private Long clase;
    /*inicio enozigli 16/11/2007 COL-CRA-001*/
  private String tipoActividad;
  private Integer campDesplazamiento;
  private String textoActOrigen;
  /*fin enozigli 16/11/2007 COL-CRA-001*/

  public DTOActividadMatriz() {
  }

  public Long getActividad() {
    return actividad;
  }

  public void setActividad(Long newActividad) {
    actividad = newActividad;
  }

  public Long getOrigen() {
    return origen;
  }

  public void setOrigen(Long newOrigen) {
    origen = newOrigen;
  }

  public Long getDia() {
    return dia;
  }

  public void setDia(Long newDia) {
    dia = newDia;
  }

  public Long getDiasFinal() {
    return diasFinal;
  }

  public void setDiasFinal(Long newDiasFinal) {
    diasFinal = newDiasFinal;
  }

  public Long getDiasIntervalo() {
    return diasIntervalo;
  }

  public void setDiasIntervalo(Long newDiasIntervalo) {
    diasIntervalo = newDiasIntervalo;
  }

  public Long getDiaPeriodo() {
    return diaPeriodo;
  }

  public void setDiaPeriodo(Long newDiaPeriodo) {
    diaPeriodo = newDiaPeriodo;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Integer getIdVista() {
    return idVista;
  }

  public void setIdVista(Integer newIdVista) {
    idVista = newIdVista;
  }

  public String getTextoActividad() {
    return textoActividad;
  }

  public void setTextoActividad(String newTextoActividad) {
    textoActividad = newTextoActividad;
  }

  public Long getGrupo() {
    return grupo;
  }

  public void setGrupo(Long newGrupo) {
    grupo = newGrupo;
  }

  public Boolean getEsMover() {
    return esMover;
  }

  public void setEsMover(Boolean newEsMover) {
    esMover = newEsMover;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String newCodigo) {
    codigo = newCodigo;
  }

  public String getTextoGrupo() {
    return textoGrupo;
  }

  public void setTextoGrupo(String newTextoGrupo) {
    textoGrupo = newTextoGrupo;
  }

    public Long getClase() {
        return clase;
    }

    public void setClase(Long newClase) {
        clase = newClase;
    }

/*inicio enozigli 16/11/2007 COL-CRA-001*/
  public String getTipoActividad() {
    return tipoActividad;
  }

  public void setTipoActividad(String tipoActividad) {
    this.tipoActividad = tipoActividad;
  }

  public Integer getCampDesplazamiento() {
    return campDesplazamiento;
  }

  public void setCampDesplazamiento(Integer campDesplazamiento) {
    this.campDesplazamiento = campDesplazamiento;
  }

  public String getTextoActOrigen() {
    return textoActOrigen;
  }

  public void setTextoActOrigen(String textoActOrigen) {
    this.textoActOrigen = textoActOrigen;
  }
  /*fin enozigli 16/11/2007 COL-CRA-001*/
}