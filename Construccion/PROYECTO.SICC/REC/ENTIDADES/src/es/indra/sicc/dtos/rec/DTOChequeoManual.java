/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.util.DTOBelcorp;

public class DTOChequeoManual extends DTOSiccPaginacion  {
    public DTOChequeoManual() {
    }
    
    private Long oidPeriodo;
    private String codigoCliente;
    private Long oidTipoRevision;
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    private Long oidPeriodoDesde;
    private Long oidPeriodoHasta;    
    private String fechaDesdeInicio;
    private String fechaHastaFin;

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidTipoRevision() {
        return oidTipoRevision;
    }

    public void setOidTipoRevision(Long oidTipoRevision) {
        this.oidTipoRevision = oidTipoRevision;
    }
    
    public Long getOidPeriodoDesde() {
        return oidPeriodoDesde;
    }

    public void setOidPeriodoDesde(Long oidPeriodoDesde) {
        this.oidPeriodoDesde = oidPeriodoDesde;
    }
    
    public Long getOidPeriodoHasta() {
        return oidPeriodoHasta;
    }

    public void setOidPeriodoHasta(Long oidPeriodoHasta) {
        this.oidPeriodoHasta = oidPeriodoHasta;
    }
    
    public String getFechaDesdeInicio() {
        return fechaDesdeInicio;
    }

    public void setFechaDesdeInicio(String fechaDesdeInicio) {
        this.fechaDesdeInicio = fechaDesdeInicio;
    }
    
    public String getFechaHastaFin() {
        return fechaHastaFin;
    }

    public void setFechaHastaFin(String fechaHastaFin) {
        this.fechaHastaFin = fechaHastaFin;
    }
}