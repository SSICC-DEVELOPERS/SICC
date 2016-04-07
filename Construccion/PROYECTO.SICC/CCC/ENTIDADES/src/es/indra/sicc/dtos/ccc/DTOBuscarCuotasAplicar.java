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


public class DTOBuscarCuotasAplicar extends DTOBelcorp {
    private Long oidCliente;
    private Long oidEmpresa;
    private Long[] marcasSituacion;
    private Integer numeroIdentCuota;
    private BigDecimal importePago;
    private String indEmisionVto;

    public DTOBuscarCuotasAplicar() {
        super();
    }

    public BigDecimal getImportePago() {
        return importePago;
    }

    public void setImportePago(BigDecimal newImportePago) {
        importePago = newImportePago;
    }

    public String getIndEmisionVto() {
        return indEmisionVto;
    }

    public void setIndEmisionVto(String newIndEmisionVto) {
        indEmisionVto = newIndEmisionVto;
    }

    public Long[] getMarcasSituacion() {
        return marcasSituacion;
    }

    public void setMarcasSituacion(Long[] newMarcasSituacion) {
        marcasSituacion = newMarcasSituacion;
    }

    public Integer getNumeroIdentCuota() {
        return numeroIdentCuota;
    }

    public void setNumeroIdentCuota(Integer newNumeroIdentCuota) {
        numeroIdentCuota = newNumeroIdentCuota;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public Long getOidEmpresa() {
        return oidEmpresa;
    }

    public void setOidEmpresa(Long newOidEmpresa) {
        oidEmpresa = newOidEmpresa;
    }
}
