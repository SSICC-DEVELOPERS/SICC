/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.Date;


public class DTOBuscarConfirmarMovBanc extends DTOSiccPaginacion {
    private Long oidBanco;
    private Long oidCuentaCorriente;
    private Date fechaMovimiento;
    private Long numeroLote;

    public DTOBuscarConfirmarMovBanc() {
        super();
    }

    public Date getFechaMovimiento() {
        return this.fechaMovimiento;
    }

    public void setFechaMovimiento(Date newFechaMovimiento) {
        this.fechaMovimiento = newFechaMovimiento;
    }

    public Long getNumeroLote() {
        return this.numeroLote;
    }

    public void setNumeroLote(Long newNumeroLote) {
        this.numeroLote = newNumeroLote;
    }

    public Long getOidBanco() {
        return this.oidBanco;
    }

    public void setOidBanco(Long newOidBanco) {
        this.oidBanco = newOidBanco;
    }

    public Long getOidCuentaCorriente() {
        return this.oidCuentaCorriente;
    }

    public void setOidCuentaCorriente(Long newOidCuentaCorriente) {
        this.oidCuentaCorriente = newOidCuentaCorriente;
    }
}
