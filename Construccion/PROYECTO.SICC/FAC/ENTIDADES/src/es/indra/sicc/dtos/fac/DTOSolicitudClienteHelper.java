package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTOSolicitudClienteHelper extends DTOBelcorp {
    private Long oidPais;
    private Long oidCliente;
    private Long oidUbigeo;
    private Long oidTerritorio;

    public DTOSolicitudClienteHelper(){    
    }

    public Long getOidPais()
    {
        return oidPais;
    }

    public void setOidPais(Long oidPais)
    {
        this.oidPais = oidPais;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }

    public Long getOidUbigeo()
    {
        return oidUbigeo;
    }

    public void setOidUbigeo(Long oidUbigeo)
    {
        this.oidUbigeo = oidUbigeo;
    }

    public Long getOidTerritorio()
    {
        return oidTerritorio;
    }

    public void setOidTerritorio(Long oidTerritorio)
    {
        this.oidTerritorio = oidTerritorio;
    }





}