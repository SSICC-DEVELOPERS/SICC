package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOUnidadesZonasSublineas extends DTOBelcorp {
    private Long oidSublinea;
    private Long idZona;
    private Long unidadesAsignadas;

    public DTOUnidadesZonasSublineas() { }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }

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
}