package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOSublineaEvaluarCarga extends DTOBelcorp {
    private Long oidSublinea;
    private String descripcion;
    private Float errorPromedio;
    private Float unidadesPromedio;
    private ArrayList zonas;

    public DTOSublineaEvaluarCarga() { }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Float getErrorPromedio()
    {
        return errorPromedio;
    }

    public void setErrorPromedio(Float errorPromedio)
    {
        this.errorPromedio = errorPromedio;
    }

    public Float getUnidadesPromedio()
    {
        return unidadesPromedio;
    }

    public void setUnidadesPromedio(Float unidadesPromedio)
    {
        this.unidadesPromedio = unidadesPromedio;
    }

    public ArrayList getZonas()
    {
        return zonas;
    }

    public void setZonas(ArrayList zonas)
    {
        this.zonas = zonas;
    }
}