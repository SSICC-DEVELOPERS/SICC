package es.indra.sicc.dtos.cra;

import es.indra.sicc.util.DTOBelcorp;

import java.util.Vector;

public class DTOGenerarCronogramaporZonas extends DTOBelcorp
{
    private Long oidPeriodo;
    private Long oidZonaReferencia;
    private Vector oidsZonasRegenerar;
    private Boolean hayQueBorrar;

    public DTOGenerarCronogramaporZonas() {
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidZonaReferencia()
    {
        return oidZonaReferencia;
    }

    public void setOidZonaReferencia(Long oidZonaReferencia)
    {
        this.oidZonaReferencia = oidZonaReferencia;
    }

    public Vector getOidsZonasRegenerar()
    {
        return oidsZonasRegenerar;
    }

    public void setOidsZonasRegenerar(Vector oidsZonasRegenerar)
    {
        this.oidsZonasRegenerar = oidsZonasRegenerar;
    }

    public Boolean getHayQueBorrar()
    {
        return hayQueBorrar;
    }

    public void setHayQueBorrar(Boolean hayQueBorrar)
    {
        this.hayQueBorrar = hayQueBorrar;
    }
    
}