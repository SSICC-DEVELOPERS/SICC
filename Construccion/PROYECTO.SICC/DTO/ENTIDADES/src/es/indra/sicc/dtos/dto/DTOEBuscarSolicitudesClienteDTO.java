/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOEBuscarSolicitudesClienteDTO 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024-1
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOEBuscarSolicitudesClienteDTO extends DTOSiccPaginacion {

    private Long oidMarca;
    private Long oidCanal;
    private Long oidCliente;
    private Long periodoDesde;
    private Long periodoHasta;

    public DTOEBuscarSolicitudesClienteDTO() {
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