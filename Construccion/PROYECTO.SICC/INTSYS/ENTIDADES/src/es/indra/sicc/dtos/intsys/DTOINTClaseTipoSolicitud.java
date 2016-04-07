package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTClaseTipoSolicitud extends DTOBelcorp {
    public DTOINTClaseTipoSolicitud()
    {  
    }
    
        private Long oidTipoSolicitud;            
        private String codigoTipoSolicitud;       
        private String descripcionTipoSolicitud;  
        private Long oidClaseSolicitud;           
        private String codigoClaseSolicitud;      
        private String descripcionClaseSolicitud; 

    public String getCodigoClaseSolicitud()
    {
        return codigoClaseSolicitud;
    }

    public void setCodigoClaseSolicitud(String codigoClaseSolicitud)
    {
        this.codigoClaseSolicitud = codigoClaseSolicitud;
    }

    public String getCodigoTipoSolicitud()
    {
        return codigoTipoSolicitud;
    }

    public void setCodigoTipoSolicitud(String codigoTipoSolicitud)
    {
        this.codigoTipoSolicitud = codigoTipoSolicitud;
    }

    public String getDescripcionClaseSolicitud()
    {
        return descripcionClaseSolicitud;
    }

    public void setDescripcionClaseSolicitud(String descripcionClaseSolicitud)
    {
        this.descripcionClaseSolicitud = descripcionClaseSolicitud;
    }

    public String getDescripcionTipoSolicitud()
    {
        return descripcionTipoSolicitud;
    }

    public void setDescripcionTipoSolicitud(String descripcionTipoSolicitud)
    {
        this.descripcionTipoSolicitud = descripcionTipoSolicitud;
    }

    public Long getOidClaseSolicitud()
    {
        return oidClaseSolicitud;
    }

    public void setOidClaseSolicitud(Long oidClaseSolicitud)
    {
        this.oidClaseSolicitud = oidClaseSolicitud;
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