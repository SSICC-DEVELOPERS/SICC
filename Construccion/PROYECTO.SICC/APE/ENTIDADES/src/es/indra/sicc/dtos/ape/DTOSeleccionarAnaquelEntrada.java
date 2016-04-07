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

import es.indra.sicc.util.DTOBelcorp;


public class DTOSeleccionarAnaquelEntrada extends DTOBelcorp {
    private String codProducto;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidPeriodo;
    private Long oidZona;
    private Long oidLinea;
    private Boolean indFueraCajaBolsa;
    private Long oidMapaCD;
    private Long oidMapaZonas;
    private Long oidTipoSolicitudConsolidado;


    public DTOSeleccionarAnaquelEntrada() {
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidLinea(Long oidLinea) {
        this.oidLinea = oidLinea;
    }

    public Long getOidLinea() {
        return oidLinea;
    }

    public void setIndFueraCajaBolsa(Boolean indFueraCajaBolsa) {
        this.indFueraCajaBolsa = indFueraCajaBolsa;
    }

    public Boolean getIndFueraCajaBolsa() {
        return indFueraCajaBolsa;
    }

    public void setOidMapaCD(Long oidMapaCD) {
        this.oidMapaCD = oidMapaCD;
    }

    public Long getOidMapaCD() {
        return oidMapaCD;
    }

    public void setOidMapaZonas(Long oidMapaZonas) {
        this.oidMapaZonas = oidMapaZonas;
    }

    public Long getOidMapaZonas() {
        return oidMapaZonas;
    }

    public void setOidTipoSolicitudConsolidado(Long oidTipoSolicitudConsolidado) {
        this.oidTipoSolicitudConsolidado = oidTipoSolicitudConsolidado;
    }

    public Long getOidTipoSolicitudConsolidado() {
        return oidTipoSolicitudConsolidado;
    }

}