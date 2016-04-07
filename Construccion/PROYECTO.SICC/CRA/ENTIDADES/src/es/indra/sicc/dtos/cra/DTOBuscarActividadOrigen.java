/**
 * Copyright 2008 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarActividadOrigen extends DTOBelcorp 
{
    private Long oidPeriodo;
    private Long oidZona;
    private Long oidActividad;

    public DTOBuscarActividadOrigen()
    {
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidZona()
    {
        return oidZona;
    }

    public void setOidZona(Long oidZona)
    {
        this.oidZona = oidZona;
    }

    public Long getOidActividad()
    {
        return oidActividad;
    }

    public void setOidActividad(Long oidActividad)
    {
        this.oidActividad = oidActividad;
    }
}