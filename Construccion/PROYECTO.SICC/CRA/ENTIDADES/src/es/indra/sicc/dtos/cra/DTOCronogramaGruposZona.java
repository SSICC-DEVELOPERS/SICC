/*
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

import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Collection;
import java.sql.Date;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     Componente importado de la Version 2 y modificado, segun
 *                    requerimientos generales de la V3
 * @version           1.0
 * @autor             Gaston Acevedo
 */
public class DTOCronogramaGruposZona extends DTOAuditableSICC {

    private Long oid;
    private Collection grupoZonaActividad;
    private Boolean existe;
    private Boolean iteraccion;
    private Date fecha0;
    private Date fechaFin;
    private Date fechaPrevista;
    private Integer fechaMedia;
    private Integer tipoDias;
    private String tipoFacturacion;
    private Long actividad;
    private DTOPeriodo periodo;
   

    public DTOCronogramaGruposZona() {
        super();
    }

    public Long getActividad() {
        return actividad;
    }

    public void setActividad(Long newActividad) {
        actividad = newActividad;
    }

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean newExiste) {
        existe = newExiste;
    }

    public Date getFecha0() {
        return fecha0;
    }

    public void setFecha0(Date newFecha0) {
        fecha0 = newFecha0;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date newFechaFin) {
        fechaFin = newFechaFin;
    }

    public Integer getFechaMedia() {
        return fechaMedia;
    }

    public void setFechaMedia(Integer newFechaMedia) {
        fechaMedia = newFechaMedia;
    }

    public Date getFechaPrevista() {
        return fechaPrevista;
    }

    public void setFechaPrevista(Date newFechaPrevista) {
        fechaPrevista = newFechaPrevista;
    }

    public Collection getGrupoZonaActividad() {
        return grupoZonaActividad;
    }

    public void setGrupoZonaActividad(Collection newGrupoZonaActividad) {
        grupoZonaActividad = newGrupoZonaActividad;
    }

    public Boolean getIteraccion() {
        return iteraccion;
    }

    public void setIteraccion(Boolean newIteraccion) {
        iteraccion = newIteraccion;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Integer getTipoDias() {
        return tipoDias;
    }

    public void setTipoDias(Integer newTipoDias) {
        tipoDias = newTipoDias;
    }

    public String getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(String newTipoFacturacion) {
        tipoFacturacion = newTipoFacturacion;
    }

    public DTOPeriodo getPeriodo()  {
        return periodo;
    }

    public void setPeriodo(DTOPeriodo newPeriodo) {
        periodo = newPeriodo;
    }

}
