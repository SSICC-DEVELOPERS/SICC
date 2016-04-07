/**
 * Copyright 2008 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35obtienePeriodosPosteriores
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
import java.sql.Timestamp;

public class DTOCalcularFechaPrevista extends DTOBelcorp 
{
    private Integer diasDesplazamiento;
    private Long oidActividad;
    private Long oidZona;
    private Timestamp fechaActividadOrigen;
    private Long oidMarca;
    private Long oidCanal;

    public DTOCalcularFechaPrevista()
    {
    }

    public Integer getDiasDesplazamiento()
    {
        return diasDesplazamiento;
    }

    public void setDiasDesplazamiento(Integer diasDesplazamiento)
    {
        this.diasDesplazamiento = diasDesplazamiento;
    }

    public Long getOidActividad()
    {
        return oidActividad;
    }

    public void setOidActividad(Long oidActividad)
    {
        this.oidActividad = oidActividad;
    }

    public Long getOidZona()
    {
        return oidZona;
    }

    public void setOidZona(Long oidGrupoZona)
    {
        this.oidZona = oidGrupoZona;
    }

    public Timestamp getFechaActividadOrigen()
    {
        return fechaActividadOrigen;
    }

    public void setFechaActividadOrigen(Timestamp fechaActividadOrigen)
    {
        this.fechaActividadOrigen = fechaActividadOrigen;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }
}