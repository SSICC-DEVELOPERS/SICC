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
package es.indra.sicc.dtos.rec;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.util.Date;

public class DTOGuardarGeneracion extends DTODatosPreRec 
{
    private RecordSet lstNoGenerar;
    private Long oidAcceso;
    private Long oidSubAcceso;
    private Long oidPeriodo;
    private ArrayList arrayTipoSolicitud;
    private String observaciones;
    // atributo oidPrecioEnvia eliminado por incidencia BELC300014892
    private Long oidTipoOperacion;  //aniadido por incidencia 16012
    private Date fechaGeneracion; // incidencia BELC300019804
    
    public DTOGuardarGeneracion()
    {
    }

    public ArrayList getArrayTipoSolicitud()
    {
        return arrayTipoSolicitud;
    }

    public void setArrayTipoSolicitud(ArrayList arrayTipoSolicitud)
    {
        this.arrayTipoSolicitud = arrayTipoSolicitud;
    }

    public RecordSet getLstNoGenerar()
    {
        return lstNoGenerar;
    }

    public void setLstNoGenerar(RecordSet lstNoGenerar)
    {
        this.lstNoGenerar = lstNoGenerar;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }



    public Long getOidSubAcceso()
    {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long oidSubAcceso)
    {
        this.oidSubAcceso = oidSubAcceso;
    }

    public Long getOidTipoOperacion()
    {
        return oidTipoOperacion;
    }

    public void setOidTipoOperacion(Long oidTipoOperacion)
    {
        this.oidTipoOperacion = oidTipoOperacion;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
}