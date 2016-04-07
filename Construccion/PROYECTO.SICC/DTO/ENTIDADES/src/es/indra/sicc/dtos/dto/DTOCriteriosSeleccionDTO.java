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


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOCriteriosSeleccionDTO 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOCriteriosSeleccionDTO extends DTOAuditableSICC {
    private Long oidMarca;
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidSubacceso;
    private Long oidPeriodo;
    private Long oidCliente;
    private Long oidZona;
    private Long oidRegion;
    private Long oidSubgerencia;

    public DTOCriteriosSeleccionDTO() {
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

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long newOidAcceso)
    {
        oidAcceso = newOidAcceso;
    }

    public Long getOidSubacceso()
    {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long newOidSubacceso)
    {
        oidSubacceso = newOidSubacceso;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo)
    {
        oidPeriodo = newOidPeriodo;
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

    public Long getOidRegion()
    {
        return oidRegion;
    }

    public void setOidRegion(Long newOidRegion)
    {
        oidRegion = newOidRegion;
    }

    public Long getOidSubgerencia()
    {
        return oidSubgerencia;
    }

    public void setOidSubgerencia(Long newOidSubgerencia)
    {
        oidSubgerencia = newOidSubgerencia;
    }
}