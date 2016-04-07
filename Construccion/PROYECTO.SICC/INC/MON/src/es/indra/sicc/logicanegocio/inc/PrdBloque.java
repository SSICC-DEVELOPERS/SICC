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

public abstract class PrdBloque implements Serializable {
    private Periodo periodoDesde;
    private Periodo periodoHasta;
    private Double puntosUnidad;
    private Double factorMultiplicador;
    private Long unidadesExigidas;
    private BigDecimal montoExigido;
    private Double puntosExigidos;
    private Long oidProductoExigido;
    //jrivas 20090807 17/4/2009 
    private String indAgrupacion = null;

    public PrdBloque() {
    }

    /*
     * Valida que el producto identificado
     * por la posicion este definido dentro de algun bloque
     * de definicion para el periodo de la solicitud.
     */
    public abstract boolean validarProducto(Posicion prd, Long oidConcurso);

    public Periodo getPeriodoDesde() {
        return periodoDesde;
    }

    public void setPeriodoDesde(Periodo periodoDesde) {
        this.periodoDesde = periodoDesde;
    }

    public Periodo getPeriodoHasta() {
        return periodoHasta;
    }

    public void setPeriodoHasta(Periodo periodoHasta) {
        this.periodoHasta = periodoHasta;
    }

    public Double getPuntosUnidad() {
        return puntosUnidad;
    }

    public void setPuntosUnidad(Double puntosUnidad) {
        this.puntosUnidad = puntosUnidad;
    }

    public Double getFactorMultiplicador() {
        return factorMultiplicador;
    }

    public void setFactorMultiplicador(Double factorMultiplicador) {
        this.factorMultiplicador = factorMultiplicador;
    }

    public Long getUnidadesExigidas() {
        return unidadesExigidas;
    }

    public void setUnidadesExigidas(Long unidadesExigidas) {
        this.unidadesExigidas = unidadesExigidas;
    }

    public BigDecimal getMontoExigido() {
        return montoExigido;
    }

    public void setMontoExigido(BigDecimal montoExigido) {
        this.montoExigido = montoExigido;
    }

    public Double getPuntosExigidos() {
        return puntosExigidos;
    }

    public void setPuntosExigidos(Double puntosExigidos) {
        this.puntosExigidos = puntosExigidos;
    }

    public Long getOidProductoExigido() {
        return oidProductoExigido;
    }

    public void setOidProductoExigido(Long oidProductoExigido) {
        this.oidProductoExigido = oidProductoExigido;
    }
    
    
    public String getIndAgrupacion() {
        return indAgrupacion;
    }

    public void setIndAgrupacion(String indAgrupacion) {
        this.indAgrupacion = indAgrupacion;
    }    

}
