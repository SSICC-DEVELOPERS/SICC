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

import java.sql.Date;

public class DTODocumentoReferenciaREC extends DTOSiccPaginacion  {
    private Long oidSolicitud = null;
    private Date fechaFiltro = null;
    private Long oidCliente = null;
    
    public DTODocumentoReferenciaREC() {
    }

    public Date getFechaFiltro() {
        return fechaFiltro;
    }

    public void setFechaFiltro(Date fechaFiltro) {
        this.fechaFiltro = fechaFiltro;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidSolicitud() {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long oidSolicitud) {
        this.oidSolicitud = oidSolicitud;
    }
}