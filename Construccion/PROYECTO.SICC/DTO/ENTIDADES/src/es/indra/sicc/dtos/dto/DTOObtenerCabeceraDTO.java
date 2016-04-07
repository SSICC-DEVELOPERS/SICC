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

import java.sql.Date;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOObtenerCabeceraDTO 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOObtenerCabeceraDTO extends DTOAuditableSICC {

    private Long oidCabecera;
    private Long oidTipoSolicitudPais;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nombrePeriodo;
    private Date fechaSolicitud;
    private BigDecimal montoTotalSolicitud;
    private String codigoCliente;
    private BigDecimal importeDescuento3TotalLocal;
    private Long oidCliente;
    private Long oidZona;
    private Long oidPeriodo;

    public DTOObtenerCabeceraDTO() {
    }

    public Long getOidCabecera()
    {
        return oidCabecera;
    }

    public void setOidCabecera(Long newOidCabecera)
    {
        oidCabecera = newOidCabecera;
    }

    public Long getOidTipoSolicitudPais()
    {
        return oidTipoSolicitudPais;
    }

    public void setOidTipoSolicitudPais(Long newOidTipoSolicitudPais)
    {
        oidTipoSolicitudPais = newOidTipoSolicitudPais;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String newNombre)
    {
        nombre = newNombre;
    }

    public String getApellido1()
    {
        return apellido1;
    }

    public void setApellido1(String newApellido1)
    {
        apellido1 = newApellido1;
    }

    public String getApellido2()
    {
        return apellido2;
    }

    public void setApellido2(String newApellido2)
    {
        apellido2 = newApellido2;
    }

    public String getNombrePeriodo()
    {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String newNombrePeriodo)
    {
        nombrePeriodo = newNombrePeriodo;
    }

    public Date getFechaSolicitud()
    {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date newFechaSolicitud)
    {
        fechaSolicitud = newFechaSolicitud;
    }

    public BigDecimal getMontoTotalSolicitud()
    {
        return montoTotalSolicitud;
    }

    public void setMontoTotalSolicitud(BigDecimal newMontoTotalSolicitud)
    {
        montoTotalSolicitud = newMontoTotalSolicitud;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public BigDecimal getImporteDescuento3TotalLocal() {
        return importeDescuento3TotalLocal;
    }

    public void setImporteDescuento3TotalLocal(BigDecimal newImporteDescuento3TotalLocal) {
        importeDescuento3TotalLocal = newImporteDescuento3TotalLocal;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente)
    {
        oidCliente = newOidCliente;
    }

    public Long getOidZona()
    {
        return oidZona;
    }

    public void setOidZona(Long newOidZona)
    {
        oidZona = newOidZona;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo)
    {
        oidPeriodo = newOidPeriodo;
    }
}