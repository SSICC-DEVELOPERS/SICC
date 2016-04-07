package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOUnidadesSublineas extends DTOBelcorp {
    private Long oidSublinea;
    private Long unidades;

    public DTOUnidadesSublineas()
    {
    }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }

    public Long getUnidades()
    {
        return unidades;
    }

    public void setUnidades(Long unidades)
    {
        this.unidades = unidades;
    }
}