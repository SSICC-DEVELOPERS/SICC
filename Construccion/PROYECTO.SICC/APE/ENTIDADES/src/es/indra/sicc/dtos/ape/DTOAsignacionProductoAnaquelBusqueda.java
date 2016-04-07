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


public class DTOAsignacionProductoAnaquelBusqueda extends DTOBelcorp {
    private Long oidLinea;
    private Long oidMapaCDCabecera;
    private Long oidPeriodo;
    private Long oidProducto;
    private Long oidCD;
    private Long oidTipoSolicitudPais;
    private Integer unidades;
    private Boolean indFueraCajaBolsa;
    private Long oidConsolidado;
    private String codProducto;


    public DTOAsignacionProductoAnaquelBusqueda() {
    }

    public void setOidLinea(Long oidLinea) {
        this.oidLinea = oidLinea;
    }

    public Long getOidLinea() {
        return oidLinea;
    }

    public void setOidMapaCDCabecera(Long oidMapaCDCabecera) {
        this.oidMapaCDCabecera = oidMapaCDCabecera;
    }

    public Long getOidMapaCDCabecera() {
        return oidMapaCDCabecera;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidCD(Long oidCD) {
        this.oidCD = oidCD;
    }

    public Long getOidCD() {
        return oidCD;
    }

    public void setOidTipoSolicitudPais(Long oidTipoSolicitudPais) {
        this.oidTipoSolicitudPais = oidTipoSolicitudPais;
    }

    public Long getOidTipoSolicitudPais() {
        return oidTipoSolicitudPais;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setIndFueraCajaBolsa(Boolean indFueraCajaBolsa) {
        this.indFueraCajaBolsa = indFueraCajaBolsa;
    }

    public Boolean getIndFueraCajaBolsa() {
        return indFueraCajaBolsa;
    }

    public void setOidConsolidado(Long oidConsolidado) {
        this.oidConsolidado = oidConsolidado;
    }

    public Long getOidConsolidado() {
        return oidConsolidado;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

}