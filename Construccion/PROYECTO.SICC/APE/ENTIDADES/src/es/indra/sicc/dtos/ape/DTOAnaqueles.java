package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOAnaqueles extends DTOBelcorp{
    private Long oidSublinea;
    private Long oidMapaCentroDistribucionDetalle;
    private Long oidAnaquelDetalle;

    public DTOAnaqueles()  {  }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }

    public Long getOidMapaCentroDistribucionDetalle()
    {
        return oidMapaCentroDistribucionDetalle;
    }

    public void setOidMapaCentroDistribucionDetalle(Long oidMapaCentroDistribucionDetalle)
    {
        this.oidMapaCentroDistribucionDetalle = oidMapaCentroDistribucionDetalle;
    }

    public Long getOidAnaquelDetalle()
    {
        return oidAnaquelDetalle;
    }

    public void setOidAnaquelDetalle(Long oidAnaquelDetalle)
    {
        this.oidAnaquelDetalle = oidAnaquelDetalle;
    }
}