/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOCalcularHit extends DTOSiccPaginacion
{
    private Long oidCentroDistribucion;
    private Long oidMapaCentroDistribucion;
    private Long oidMapaZona;
    private Long oidPeriodo;
    private Long oidLineaArmado;
    private Date fechaFactu;

    public DTOCalcularHit()
    {
    }

    public Long getOidCentroDistribucion()
    {
        return oidCentroDistribucion;
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion)
    {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getOidMapaCentroDistribucion()
    {
        return oidMapaCentroDistribucion;
    }

    public void setOidMapaCentroDistribucion(Long oidMapaCentroDistribucion)
    {
        this.oidMapaCentroDistribucion = oidMapaCentroDistribucion;
    }

    public Long getOidMapaZona()
    {
        return oidMapaZona;
    }

    public void setOidMapaZona(Long oidMapaZona)
    {
        this.oidMapaZona = oidMapaZona;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidLineaArmado()
    {
        return oidLineaArmado;
    }

    public void setOidLineaArmado(Long oidLineaArmado)
    {
        this.oidLineaArmado = oidLineaArmado;
    }

    public Date getFechaFactu()
    {
        return fechaFactu;
    }

    public void setFechaFactu(Date fechaFactu)
    {
        this.fechaFactu = fechaFactu;
    }
}