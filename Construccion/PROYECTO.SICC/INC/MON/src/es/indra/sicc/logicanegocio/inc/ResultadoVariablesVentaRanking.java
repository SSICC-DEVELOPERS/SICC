/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor: Diego Morello
 *
 */
package es.indra.sicc.logicanegocio.inc;

import java.math.BigDecimal;

public class ResultadoVariablesVentaRanking {
    private BigDecimal importeVentas;
    private Long unidades;
    private Long activasIniciales;
    private Integer activasFinales;
    private BigDecimal numeroPedidos;
    private BigDecimal porcentajeActividad;
    private BigDecimal constancia;
    private BigDecimal ingresos;
    private BigDecimal reingresos;
    private BigDecimal egresos;
    private BigDecimal entregadas;
    private BigDecimal recibidas;
    private BigDecimal capitalizacion;
    private BigDecimal ppu;
    private BigDecimal pvp;
    private BigDecimal pup;
    private BigDecimal pop;
    private BigDecimal retencion;
    private BigDecimal cobranza;
    private BigDecimal rotacion;

    public ResultadoVariablesVentaRanking() {
    }

    public BigDecimal getImporteVentas() {
        return importeVentas;
    }

    public void setImporteVentas(BigDecimal importeVentas) {
        this.importeVentas = importeVentas;
    }

    public Long getUnidades() {
        return unidades;
    }

    public void setUnidades(Long unidades) {
        this.unidades = unidades;
    }

    public Long getActivasIniciales() {
        return activasIniciales;
    }

    public void setActivasIniciales(Long activasIniciales) {
        this.activasIniciales = activasIniciales;
    }

    public Integer getActivasFinales() {
        return activasFinales;
    }

    public void setActivasFinales(Integer activasFinales) {
        this.activasFinales = activasFinales;
    }

    public BigDecimal getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(BigDecimal numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public BigDecimal getPorcentajeActividad() {
        return porcentajeActividad;
    }

    public void setPorcentajeActividad(BigDecimal porcentajeActividad) {
        this.porcentajeActividad = porcentajeActividad;
    }

    public BigDecimal getConstancia() {
        return constancia;
    }

    public void setConstancia(BigDecimal constancia) {
        this.constancia = constancia;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    public BigDecimal getReingresos() {
        return reingresos;
    }

    public void setReingresos(BigDecimal reingresos) {
        this.reingresos = reingresos;
    }

    public BigDecimal getEgresos() {
        return egresos;
    }

    public void setEgresos(BigDecimal egresos) {
        this.egresos = egresos;
    }

    public BigDecimal getEntregadas() {
        return entregadas;
    }

    public void setEntregadas(BigDecimal entregadas) {
        this.entregadas = entregadas;
    }

    public BigDecimal getRecibidas() {
        return recibidas;
    }

    public void setRecibidas(BigDecimal recibidas) {
        this.recibidas = recibidas;
    }

    public BigDecimal getCapitalizacion() {
        return capitalizacion;
    }

    public void setCapitalizacion(BigDecimal capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public BigDecimal getPpu() {
        return ppu;
    }

    public void setPpu(BigDecimal ppu) {
        this.ppu = ppu;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public BigDecimal getPup() {
        return pup;
    }

    public void setPup(BigDecimal pup) {
        this.pup = pup;
    }

    public BigDecimal getPop() {
        return pop;
    }

    public void setPop(BigDecimal pop) {
        this.pop = pop;
    }

    public BigDecimal getRetencion() {
        return retencion;
    }

    public void setRetencion(BigDecimal retencion) {
        this.retencion = retencion;
    }

    public BigDecimal getCobranza() {
        return cobranza;
    }

    public void setCobranza(BigDecimal cobranza) {
        this.cobranza = cobranza;
    }

    public BigDecimal getRotacion() {
        return rotacion;
    }

    public void setRotacion(BigDecimal rotacion) {
        this.rotacion = rotacion;
    }

    public String toString() {
        StringBuffer strResult = new StringBuffer();
        strResult.append("[ ");
        strResult.append("impVent=" + importeVentas + ", ");
        strResult.append("unid=" + unidades + ", ");
        strResult.append("actIni=" + activasIniciales + ", ");
        strResult.append("actFin=" + activasFinales + ", ");
        strResult.append("numPed=" + numeroPedidos + ", ");
        strResult.append("porcAct=" + porcentajeActividad + ", ");
        strResult.append("const=" + constancia + ", ");
        strResult.append("ingr=" + ingresos + ", ");
        strResult.append("reingr=" + reingresos + ", ");
        strResult.append("egr=" + egresos + ", ");
        strResult.append("entr=" + entregadas + ", ");
        strResult.append("recib=" + recibidas + ", ");
        strResult.append("cap=" + capitalizacion + ", ");
        strResult.append("ppu=" + ppu + ", ");
        strResult.append("pvp=" + pvp + ", ");
        strResult.append("pup=" + pup + ", ");
        strResult.append("pop=" + pop + ", ");
        strResult.append("ret=" + retencion + ", ");
        strResult.append("cobr=" + cobranza + ", ");
        strResult.append("rot=" + rotacion);
        strResult.append(" ]");

        return strResult.toString();
    }
}
