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
 */

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOEBuscarClientesDTO 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

public class DTOEBuscarClientesDTO extends DTOSiccPaginacion {

    private Long oidMarca;
    private Long oidCanal;
    private Long oidCliente;
    private String codigoCliente;
    private Long periodoDesde;
    private Long periodoHasta;

    public DTOEBuscarClientesDTO() {
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long newOidMarca)
    {
        oidMarca = newOidMarca;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long newOidCanal)
    {
        oidCanal = newOidCanal;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente)
    {
        oidCliente = newOidCliente;
    }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente)
    {
        codigoCliente = newCodigoCliente;
    }

    public Long getPeriodoDesde()
    {
        return periodoDesde;
    }

    public void setPeriodoDesde(Long newPeriodoDesde)
    {
        periodoDesde = newPeriodoDesde;
    }

    public Long getPeriodoHasta()
    {
        return periodoHasta;
    }

    public void setPeriodoHasta(Long newPeriodoHasta)
    {
        periodoHasta = newPeriodoHasta;
    }

}