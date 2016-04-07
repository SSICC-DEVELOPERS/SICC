package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOUnidadesProducto extends DTOBelcorp {
    private Long oidProducto;
    private Long unidadesEstimadas;
    private Boolean asignado;
    private Long oidSublinea;

    public DTOUnidadesProducto()  { }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

    public Long getUnidadesEstimadas()
    {
        return unidadesEstimadas;
    }

    public void setUnidadesEstimadas(Long unidadesEstimadas)
    {
        this.unidadesEstimadas = unidadesEstimadas;
    }

    public Boolean getAsignado()
    {
        return asignado;
    }

    public void setAsignado(Boolean asignado)
    {
        this.asignado = asignado;
    }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }
}