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

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.math.BigDecimal;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOAcumuladoVenta 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOAcumuladoVenta extends DTOAuditableSICC {
    private BigDecimal montoVentaSolicitud;
    private BigDecimal montoVentaAcumulado;
    private Long numeroUnidadesSolicitud;
    private Long numeroUnidadesAcumulado;

    public DTOAcumuladoVenta()  {

    }

    public BigDecimal getMontoVentaSolicitud()
    {
        return montoVentaSolicitud;
    }

    public void setMontoVentaSolicitud(BigDecimal newMontoVentaSolicitud)
    {
        montoVentaSolicitud = newMontoVentaSolicitud;
    }

    public BigDecimal getMontoVentaAcumulado()
    {
        return montoVentaAcumulado;
    }

    public void setMontoVentaAcumulado(BigDecimal newMontoVentaAcumulado)
    {
        montoVentaAcumulado = newMontoVentaAcumulado;
    }

    public Long getNumeroUnidadesSolicitud()
    {
        return numeroUnidadesSolicitud;
    }

    public void setNumeroUnidadesSolicitud(Long newNumeroUnidadesSolicitud)
    {
        numeroUnidadesSolicitud = newNumeroUnidadesSolicitud;
    }

    public Long getNumeroUnidadesAcumulado()
    {
        return numeroUnidadesAcumulado;
    }

    public void setNumeroUnidadesAcumulado(Long newNumeroUnidadesAcumulado)
    {
        numeroUnidadesAcumulado = newNumeroUnidadesAcumulado;
    }


}