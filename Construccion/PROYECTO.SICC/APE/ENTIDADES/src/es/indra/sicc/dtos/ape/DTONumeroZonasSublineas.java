package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTONumeroZonasSublineas extends DTOBelcorp {
    private Long oidSublinea;
    private Long numero;

    public DTONumeroZonasSublineas() { }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }

    public Long getNumero()
    {
        return numero;
    }

    public void setNumero(Long numero)
    {
        this.numero = numero;
    }
}