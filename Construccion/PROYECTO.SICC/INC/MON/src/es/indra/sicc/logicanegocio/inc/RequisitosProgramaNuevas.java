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

public class RequisitosProgramaNuevas implements Serializable {
    private Long numeroPeriodosEvaluar;
    private BigDecimal exigenciaMinima;
    private Long oidTipoRequisito;
    private Long nivelPremiacion;
    private Long numeroPedidosAPremiar;
    private Long numeroPedido;

    public RequisitosProgramaNuevas() {
    }

    public Long getNumeroPeriodosEvaluar() {
        return numeroPeriodosEvaluar;
    }

    public void setNumeroPeriodosEvaluar(Long numeroPeriodosEvaluar) {
        this.numeroPeriodosEvaluar = numeroPeriodosEvaluar;
    }

    public BigDecimal getExigenciaMinima() {
        return exigenciaMinima;
    }

    public void setExigenciaMinima(BigDecimal exigenciaMinima) {
        this.exigenciaMinima = exigenciaMinima;
    }

    public Long getOidTipoRequisito() {
        return oidTipoRequisito;
    }

    public void setOidTipoRequisito(Long oidTipoRequisito) {
        this.oidTipoRequisito = oidTipoRequisito;
    }

    public Long getNivelPremiacion() {
        return nivelPremiacion;
    }

    public void setNivelPremiacion(Long nivelPremiacion) {
        this.nivelPremiacion = nivelPremiacion;
    }

    public Long getNumeroPedidosAPremiar() {
        return numeroPedidosAPremiar;
    }

    public void setNumeroPedidosAPremiar(Long numeroPedidosAPremiar) {
        this.numeroPedidosAPremiar = numeroPedidosAPremiar;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
}
