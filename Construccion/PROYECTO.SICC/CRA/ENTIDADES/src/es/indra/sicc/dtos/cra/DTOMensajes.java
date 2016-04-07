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

package es.indra.sicc.dtos.cra;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:       Belcorp
 * Modulo:        CRA - Cronograma de Actividades
 * Componente:    DTOMensajes 
 * Fecha:         05/11/2003
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
 
public class DTOMensajes extends DTOAuditableSICC 
{
    Long oidPais;
    Long oidMarca;
    Long oidCanal;
    Long oidPeriodo;
    Long oidSubgerencia;
    Long oidRegio;
    Long oidZona;
    Long oidSeccion;

    public DTOMensajes()
    {
    }

    public Long getOidPais()
    {
        return oidPais;
    }

    public void setOidPais(Long newOidPais)
    {
        oidPais = newOidPais;
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

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo)
    {
        oidPeriodo = newOidPeriodo;
    }

    public Long getOidSubgerencia()
    {
        return oidSubgerencia;
    }

    public void setOidSubgerencia(Long newOidSubgerencia)
    {
        oidSubgerencia = newOidSubgerencia;
    }

    public Long getOidRegio()
    {
        return oidRegio;
    }

    public void setOidRegio(Long newOidRegio)
    {
        oidRegio = newOidRegio;
    }

    public Long getOidZona()
    {
        return oidZona;
    }

    public void setOidZona(Long newOidZona)
    {
        oidZona = newOidZona;
    }

    public Long getOidSeccion()
    {
        return oidSeccion;
    }

    public void setOidSeccion(Long newOidSeccion)
    {
        oidSeccion = newOidSeccion;
    }
}