package es.indra.sicc.dtos.com;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;

/**
 * 
 * @date 
 * @author ciglesias
 */
public class DTOTipoClienteComDetalle extends DTOSiccPaginacion
{

    private Long idSubclasificacion;
    private Long oidSubtipoCliente;
    private Long oidClasificacion;
    private Long oidTipoClasificacion;
    private Long oidTipoCliente;
    private String descripcion;
    private Long oidTipoClienteComDetalle;
    private Vector vectorTraducciones;
    
    
    public DTOTipoClienteComDetalle()
    {
    }


    public void setIdSubclasificacion(Long idSubclasificacion)
    {
        this.idSubclasificacion = idSubclasificacion;
    }


    public Long getIdSubclasificacion()
    {
        return idSubclasificacion;
    }


    public void setOidSubtipoCliente(Long oidSubtipoCliente)
    {
        this.oidSubtipoCliente = oidSubtipoCliente;
    }


    public Long getOidSubtipoCliente()
    {
        return oidSubtipoCliente;
    }


    public void setOidClasificacion(Long oidClasificacion)
    {
        this.oidClasificacion = oidClasificacion;
    }


    public Long getOidClasificacion()
    {
        return oidClasificacion;
    }


    public void setOidTipoClasificacion(Long oidTipoClasificacion)
    {
        this.oidTipoClasificacion = oidTipoClasificacion;
    }


    public Long getOidTipoClasificacion()
    {
        return oidTipoClasificacion;
    }


    public void setOidTipoCliente(Long oidTipoCliente)
    {
        this.oidTipoCliente = oidTipoCliente;
    }


    public Long getOidTipoCliente()
    {
        return oidTipoCliente;
    }


    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }


    public String getDescripcion()
    {
        return descripcion;
    }


    public void setOidTipoClienteComDetalle(Long oidTipoClienteComDetalle)
    {
        this.oidTipoClienteComDetalle = oidTipoClienteComDetalle;
    }


    public Long getOidTipoClienteComDetalle()
    {
        return oidTipoClienteComDetalle;
    }


    public void setVectorTraducciones(Vector vectorTraducciones)
    {
        this.vectorTraducciones = vectorTraducciones;
    }


    public Vector getVectorTraducciones()
    {
        return vectorTraducciones;
    }
}