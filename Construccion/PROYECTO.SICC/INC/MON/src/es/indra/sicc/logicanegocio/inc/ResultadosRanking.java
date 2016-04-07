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

public class ResultadosRanking {
    private BigDecimal montoVentas;
    private Long unidadesVendidas;
    private Long numeroPedidos;
    private Long numeroRecomendadas;
    private ClienteConcursoBaseCalculoRanking resultado;

    public void setMontoVentas(BigDecimal montoVentas) {
        this.montoVentas = montoVentas;
    }

    public BigDecimal getMontoVentas() {
        return this.montoVentas;
    }

    public void setUnidadesVendidas(Long unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public Long getUnidadesVendidas() {
        return this.unidadesVendidas;
    }

    public void setNumeroPedidos(Long numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public Long getNumeroPedidos() {
        return this.numeroPedidos;
    }

    public void setNumeroRecomendadas(Long numeroRecomendadas) {
        this.numeroRecomendadas = numeroRecomendadas;
    }

    public Long getNumeroRecomendadas() {
        return this.numeroRecomendadas;
    }

    public void setResultado(ClienteConcursoBaseCalculoRanking resultado) {
        this.resultado = resultado;
    }

    public ClienteConcursoBaseCalculoRanking getResultado() {
        return this.resultado;
    }
}
