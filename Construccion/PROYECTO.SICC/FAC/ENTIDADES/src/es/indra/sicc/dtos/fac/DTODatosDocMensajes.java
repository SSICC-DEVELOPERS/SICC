/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.fac;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.Date;


public class DTODatosDocMensajes extends DTOSiccPaginacion {
    
    private String codCliente;
    private Long tipoSolicitud;
    private Long canal;
    private Long acceso;
    private Long subAcceso;
    private Long numeroConsolidadoDesde;
    private Long numeroConsolidadoHasta;
    private Date fechaFacturacionDesde;
    private Date fechaFacturacionHasta;

    public DTODatosDocMensajes() {
        super();
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long newAcceso) {
        acceso = newAcceso;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String newCodCliente) {
        codCliente = newCodCliente;
    }

    public Date getFechaFacturacionDesde() {
        return fechaFacturacionDesde;
    }

    public void setFechaFacturacionDesde(Date newFechaFacturacionDesde) {
        fechaFacturacionDesde = newFechaFacturacionDesde;
    }

    public Date getFechaFacturacionHasta() {
        return fechaFacturacionHasta;
    }

    public void setFechaFacturacionHasta(Date newFechaFacturacionHasta) {
        fechaFacturacionHasta = newFechaFacturacionHasta;
    }

   
//Modificado por hmansi 26/10/2006
//Incidencia BELC300024372
//Se cambió el tipo de retorno de Integer a Long
    public Long getNumeroConsolidadoDesde() {
        return numeroConsolidadoDesde;
    }

//Modificado por hmansi 26/10/2006
//Incidencia BELC300024372
//Se cambió el parámetro de entrada de Integer a Long    
    public void setNumeroConsolidadoDesde(Long newNumeroConsolidadoDesde) {
        numeroConsolidadoDesde = newNumeroConsolidadoDesde;
    }

    public Long getNumeroConsolidadoHasta() {
        return numeroConsolidadoHasta;
    }

    public void setNumeroConsolidadoHasta(Long newNumeroConsolidadoHasta) {
        numeroConsolidadoHasta = newNumeroConsolidadoHasta;
    }

    public Long getSubAcceso() {
        return subAcceso;
    }

    public void setSubAcceso(Long newSubAcceso) {
        subAcceso = newSubAcceso;
    }

    public Long getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(Long newTipoSolicitud) {
        tipoSolicitud = newTipoSolicitud;
    }
}
