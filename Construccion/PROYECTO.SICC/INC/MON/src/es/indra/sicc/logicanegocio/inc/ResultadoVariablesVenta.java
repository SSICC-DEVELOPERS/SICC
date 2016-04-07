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
 */
package es.indra.sicc.logicanegocio.inc;

import java.math.BigDecimal;

public class ResultadoVariablesVenta {
    private Integer activasIniciales;
    private Integer ingresos;
    private Integer reingresos;
    private Integer egresos;
    private Integer entregadas;
    private Integer recibidas;
    private Integer activasFinales;
    private Integer capitalizacion;
    private Double porcentajeRetencion;
    private Integer numeroOrdenes;
    private Integer numeroClientes;
    private BigDecimal rotacion;

    public Integer getActivasIniciales() {
        return activasIniciales;
    }

    public void setActivasIniciales(Integer activasIniciales) {
        this.activasIniciales = activasIniciales;
    }

    public Integer getIngresos() {
        return ingresos;
    }

    public void setIngresos(Integer ingresos) {
        this.ingresos = ingresos;
    }

    public Integer getReingresos() {
        return reingresos;
    }

    public void setReingresos(Integer reingresos) {
        this.reingresos = reingresos;
    }

    public Integer getEgresos() {
        return egresos;
    }

    public void setEgresos(Integer egresos) {
        this.egresos = egresos;
    }

    public Integer getEntregadas() {
        return entregadas;
    }

    public void setEntregadas(Integer entregadas) {
        this.entregadas = entregadas;
    }

    public Integer getRecibidas() {
        return recibidas;
    }

    public void setRecibidas(Integer recibidas) {
        this.recibidas = recibidas;
    }

    public Integer getActivasFinales() {
        return activasFinales;
    }

    public void setActivasFinales(Integer activasFinales) {
        this.activasFinales = activasFinales;
    }

    public Integer getCapitalizacion() {
        return capitalizacion;
    }

    public void setCapitalizacion(Integer capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public Double getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public void setPorcentajeRetencion(Double porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public Integer getNumeroOrdenes() {
        return numeroOrdenes;
    }

    public void setNumeroOrdenes(Integer numeroOrdenes) {
        this.numeroOrdenes = numeroOrdenes;
    }

    public Integer getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(Integer numeroClientes) {
        this.numeroClientes = numeroClientes;
    }

    public BigDecimal getRotacion() {
        return rotacion;
    }

    public void setRotacion(BigDecimal rotacion) {
        this.rotacion = rotacion;
    }
}
