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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOConsultaOrdenada extends DTOSiccPaginacion {
    private Long oidFiltro;
    private Long codOrdenamiento;
    
    
    public DTOConsultaOrdenada() {
    }

    public void setOidFiltro(Long oidFiltro) {
        this.oidFiltro = oidFiltro;
    }

    public Long getOidFiltro() {
        return oidFiltro;
    }

    public void setCodOrdenamiento(Long codOrdenamiento) {
        this.codOrdenamiento = codOrdenamiento;
    }

    public Long getCodOrdenamiento() {
        return codOrdenamiento;
    }

}