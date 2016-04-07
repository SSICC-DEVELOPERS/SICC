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


public class DTODatosCupones extends DTOSiccPaginacion {
    private Long canal;
    private Long periodo;
    private Date fechaFacturacion;
    private String codCliente;
    private String regionDesde;
    private String regionHasta;
    private String zonaDesde;
    private String zonaHasta;
    private String seccionDesde;
    private String seccionHasta;
    private String territorioDesde;
    private String territorioHasta;
    private Long marca;

    public DTODatosCupones() {
        super();
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

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date newFechaFacturacion) {
        fechaFacturacion = newFechaFacturacion;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long newPeriodo) {
        periodo = newPeriodo;
    }

    public String getRegionDesde() {
        return regionDesde;
    }

    public void setRegionDesde(String newRegionDesde) {
        regionDesde = newRegionDesde;
    }

    public String getRegionHasta() {
        return regionHasta;
    }

    public void setRegionHasta(String newRegionHasta) {
        regionHasta = newRegionHasta;
    }

    public String getSeccionDesde() {
        return seccionDesde;
    }

    public void setSeccionDesde(String newSeccionDesde) {
        seccionDesde = newSeccionDesde;
    }

    public String getSeccionHasta() {
        return seccionHasta;
    }

    public void setSeccionHasta(String newSeccionHasta) {
        seccionHasta = newSeccionHasta;
    }

    public String getTerritorioDesde() {
        return territorioDesde;
    }

    public void setTerritorioDesde(String newTerritorioDesde) {
        territorioDesde = newTerritorioDesde;
    }

    public String getTerritorioHasta() {
        return territorioHasta;
    }

    public void setTerritorioHasta(String newTerritorioHasta) {
        territorioHasta = newTerritorioHasta;
    }

    public String getZonaDesde() {
        return zonaDesde;
    }

    public void setZonaDesde(String newZonaDesde) {
        zonaDesde = newZonaDesde;
    }

    public String getZonaHasta() {
        return zonaHasta;
    }

    public void setZonaHasta(String newZonaHasta) {
        zonaHasta = newZonaHasta;
    }
}
