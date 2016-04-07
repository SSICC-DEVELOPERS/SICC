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

public class EstatusVentaConsultoras implements Serializable {
    private Long oidEstatusCliente;
    private Long oidEstatusAnterior;
    private Periodo periodoDesde;
    private Periodo periodoHasta;

    public EstatusVentaConsultoras() {
    }

    public Long getOidEstatusCliente() {
        return oidEstatusCliente;
    }

    public void setOidEstatusCliente(Long oidEstatusCliente) {
        this.oidEstatusCliente = oidEstatusCliente;
    }

    public Long getOidEstatusAnterior() {
        return oidEstatusAnterior;
    }

    public void setOidEstatusAnterior(Long oidEstatusAnterior) {
        this.oidEstatusAnterior = oidEstatusAnterior;
    }

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
}
