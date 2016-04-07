package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOPorcentajeSublinea extends DTOBelcorp{
    private Long oidSublinea;
    private Float porcentaje;

    public DTOPorcentajeSublinea() {  }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
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