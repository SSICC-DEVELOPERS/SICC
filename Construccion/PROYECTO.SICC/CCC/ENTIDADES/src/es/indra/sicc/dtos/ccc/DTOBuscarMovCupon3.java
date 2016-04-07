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

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

import java.util.Date;


public class DTOBuscarMovCupon3 extends DTOBelcorp {
    private Long numeroCupon;
    private Long oidCliente;
    private Date fechaMovimiento;
    private Long oidBanco;
    private String situacion;
    private BigDecimal importe;

    public DTOBuscarMovCupon3() {
        super();
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date newFechaMovimiento) {
        fechaMovimiento = newFechaMovimiento;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal newImporte) {
        importe = newImporte;
    }

    public Long getNumeroCupon() {
        return numeroCupon;
    }

    public void setNumeroCupon(Long newNumeroCupon) {
        numeroCupon = newNumeroCupon;
    }

    public Long getOidBanco() {
        return oidBanco;
    }

    public void setOidBanco(Long newOidBanco) {
        oidBanco = newOidBanco;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String newSituacion) {
        situacion = newSituacion;
    }
}
