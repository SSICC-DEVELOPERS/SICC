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
 *
 */
package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOChequeos extends DTOBelcorp  {
    private Long nroConsolidado;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;
    private Boolean reclamo;
    private Boolean pedido;
    private Boolean manual;
    private String usuario;

    public DTOChequeos() {
    }

    public Long getNroConsolidado() {
        return nroConsolidado;
    }

    public void setNroConsolidado(Long nroConsolidado) {
        this.nroConsolidado = nroConsolidado;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidSeccion() {
        return oidSeccion;
    }

    public void setOidSeccion(Long oidSeccion) {
        this.oidSeccion = oidSeccion;
    }

    public Boolean getReclamo() {
        return reclamo;
    }

    public void setReclamo(Boolean reclamo) {
        this.reclamo = reclamo;
    }

    public Boolean getPedido() {
        return pedido;
    }

    public void setPedido(Boolean pedido) {
        this.pedido = pedido;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}