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
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoExigido implements Serializable {
    private Long oidProductoExigido;
    private BigDecimal montoPedido;
    private Long unidadesPedido;
    private Double puntosPedido;
    private BigDecimal montoSolicitud;
    private Long unidadesSolicitud;
    private Double puntosSolicitud;

    public ProductoExigido() {
        montoPedido = new BigDecimal(0);
        unidadesPedido = new Long(0);
        puntosPedido = new Double(0);
    }

    public Long getOidProductoExigido() {
        return oidProductoExigido;
    }

    public void setOidProductoExigido(Long oidProductoExigido) {
        this.oidProductoExigido = oidProductoExigido;
    }

    public BigDecimal getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(BigDecimal montoPedido) {
        this.montoPedido = montoPedido;
    }

    public Long getUnidadesPedido() {
        return unidadesPedido;
    }

    public void setUnidadesPedido(Long unidadesPedido) {
        this.unidadesPedido = unidadesPedido;
    }

    public Double getPuntosPedido() {
        return puntosPedido;
    }

    public void setPuntosPedido(Double puntosPedido) {
        this.puntosPedido = puntosPedido;
    }

    public BigDecimal getMontoSolicitud() {
        return montoSolicitud;
    }

    public void setMontoSolicitud(BigDecimal montoSolicitud) {
        this.montoSolicitud = montoSolicitud;
    }

    public Long getUnidadesSolicitud() {
        return unidadesSolicitud;
    }

    public void setUnidadesSolicitud(Long unidadesSolicitud) {
        this.unidadesSolicitud = unidadesSolicitud;
    }

    public Double getPuntosSolicitud() {
        return puntosSolicitud;
    }

    public void setPuntosSolicitud(Double puntosSolicitud) {
        this.puntosSolicitud = puntosSolicitud;
    }
}
