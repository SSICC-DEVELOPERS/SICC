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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarSolicitudAdam extends DTOBelcorp 
{
    public DTOBuscarSolicitudAdam()
    {
    }
    
    private Long oidMarca;       
    private Long oidAcceso;      
    private Long oidSubAcceso;   
    private RecordSet lstDetalle;

    public RecordSet getLstDetalle()
    {
        return lstDetalle;
    }

    public void setLstDetalle(RecordSet lstDetalle)
    {
        this.lstDetalle = lstDetalle;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public Long getOidSubAcceso()
    {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long oidSubAcceso)
    {
        this.oidSubAcceso = oidSubAcceso;
    }

    
    
}