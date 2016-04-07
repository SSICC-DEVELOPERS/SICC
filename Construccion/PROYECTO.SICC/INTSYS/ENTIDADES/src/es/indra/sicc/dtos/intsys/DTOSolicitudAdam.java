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


package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOSolicitudAdam extends DTOBelcorp 
{
    public DTOSolicitudAdam()
    {
    }
    
    private Long oidTipoCliente;      
    private Long oidTipoSolicitud;    
    private Long oidTipoPosicion;     
    private Long oidSubtipoPosicion;  
    private Long oidProducto;         

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

    public Long getOidSubtipoPosicion()
    {
        return oidSubtipoPosicion;
    }

    public void setOidSubtipoPosicion(Long oidSubtipoPosicion)
    {
        this.oidSubtipoPosicion = oidSubtipoPosicion;
    }

    public Long getOidTipoCliente()
    {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long oidTipoCliente)
    {
        this.oidTipoCliente = oidTipoCliente;
    }

    public Long getOidTipoPosicion()
    {
        return oidTipoPosicion;
    }

    public void setOidTipoPosicion(Long oidTipoPosicion)
    {
        this.oidTipoPosicion = oidTipoPosicion;
    }

    public Long getOidTipoSolicitud()
    {
        return oidTipoSolicitud;
    }

    public void setOidTipoSolicitud(Long oidTipoSolicitud)
    {
        this.oidTipoSolicitud = oidTipoSolicitud;
    }

    
    
    
    
}