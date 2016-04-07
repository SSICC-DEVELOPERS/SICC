
/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.cal;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBloqueoAdm extends DTOBelcorp
{
    private Long oidTipoBloqueo;
    private String motivoBloqueo;
    private String obsBloqueo;
    private Long oidCliente;

    public DTOBloqueoAdm()
    {
    }


    public void setOidTipoBloqueo(Long oidTipoBloqueo)
    {
        this.oidTipoBloqueo = oidTipoBloqueo;
    }


    public Long getOidTipoBloqueo()
    {
        return oidTipoBloqueo;
    }


    public void setMotivoBloqueo(String motivoBloqueo)
    {
        this.motivoBloqueo = motivoBloqueo;
    }


    public String getMotivoBloqueo()
    {
        return motivoBloqueo;
    }


    public void setObsBloqueo(String obsBloqueo)
    {
        this.obsBloqueo = obsBloqueo;
    }


    public String getObsBloqueo()
    {
        return obsBloqueo;
    }


    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }


    public Long getOidCliente()
    {
        return oidCliente;
    }
}