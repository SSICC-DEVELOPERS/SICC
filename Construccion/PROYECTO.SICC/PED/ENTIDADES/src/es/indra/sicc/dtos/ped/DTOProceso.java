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
package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOProceso 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOProceso extends DTOAuditableSICC {
    private Integer secuencia;
    private Long oidTipoPosicion;
    private Long oidSubTipoPosicion;
    private String businessID;
    private String codProceso;
    private Long oidProceso;

    public DTOProceso() {
    
    }

    public Integer getSecuencia()
    {
        return secuencia;
    }

    public void setSecuencia(Integer newSecuencia)
    {
        secuencia = newSecuencia;
    }

    public Long getOidTipoPosicion()
    {
        return oidTipoPosicion;
    }

    public void setOidTipoPosicion(Long newOidTipoPosicion)
    {
        oidTipoPosicion = newOidTipoPosicion;
    }

    public Long getOidSubTipoPosicion()
    {
        return oidSubTipoPosicion;
    }

    public void setOidSubTipoPosicion(Long newOidSubTipoPosicion)
    {
        oidSubTipoPosicion = newOidSubTipoPosicion;
    }

    public String getBusinessID()
    {
        return businessID;
    }

    public void setBusinessID(String newBusinessID)
    {
        businessID = newBusinessID;
    }

    public String getCodProceso()
    {
        return codProceso;
    }

    public void setCodProceso(String newCodProceso)
    {
        codProceso = newCodProceso;
    }

    public Long getOidProceso()
    {
        return oidProceso;
    }

    public void setOidProceso(Long newOidProceso)
    {
        oidProceso = newOidProceso;
    }

    
}