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

package es.indra.sicc.cmn.presentacion.subidaFichero;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOFicheroResultado extends DTOAuditableSICC {
    private Integer estatus;
    private String mensajeError;
    private DTORegistroError[] reporteRegistros;
    private Long IDProc;
    private String TypeProc;
    private String fecha;
    private Object datos;

    public DTOFicheroResultado() {
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer newEstatus) {
        estatus = newEstatus;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String newMensajeError) {
        mensajeError = newMensajeError;
    }

    public DTORegistroError[] getReporteRegistros() {
        return reporteRegistros;
    }

    public void setReporteRegistros(DTORegistroError[] newReporteRegistros) {
        reporteRegistros = newReporteRegistros;
    }

    public Long getIDProc() {
        return IDProc;
    }

    public void setIDProc(Long newIDProc) {
        IDProc = newIDProc;
    }

    public String getTypeProc() {
        return TypeProc;
    }

    public void setTypeProc(String newTypeProc) {
        TypeProc = newTypeProc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String newFecha) {
        fecha = newFecha;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object newDatos) {
        datos = newDatos;
    }
}
