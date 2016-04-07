package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOZonasEvaluarCarga extends DTOBelcorp{
    private Long idZona;
    private Long unidadesAsignadas;
    private Float porcentaje;

    public DTOZonasEvaluarCarga() {  }

    public Long getIdZona()
    {
        return idZona;
    }

    public void setIdZona(Long idZona)
    {
        this.idZona = idZona;
    }

    public Long getUnidadesAsignadas()
    {
        return unidadesAsignadas;
    }

    public void setUnidadesAsignadas(Long unidadesAsignadas)
    {
        this.unidadesAsignadas = unidadesAsignadas;
    }

    public Float getPorcentaje()
    {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje)
    {
        this.porcentaje = porcentaje;
    }
}