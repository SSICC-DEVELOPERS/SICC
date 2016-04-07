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
import java.util.Date;

public class DTOMostrarDeuda extends DTOBelcorp{
 
    private String numDocumento;
    private Date fechaCreacion;
    private Long oidEstatus;
    private String estatus;
    private RecordSet detalle;


    public void setNumDocumento(String numDocumento){
        this.numDocumento = numDocumento;
    }


    public String getNumDocumento(){
        return numDocumento;
    }


    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }


    public Date getFechaCreacion(){
        return fechaCreacion;
    }


    public void setOidEstatus(Long oidEstatus){
        this.oidEstatus = oidEstatus;
    }


    public Long getOidEstatus(){
        return oidEstatus;
    }


    public void setEstatus(String estatus){
        this.estatus = estatus;
    }


    public String getEstatus(){
        return estatus;
    }


    public void setDetalle(RecordSet detalle){
        this.detalle = detalle;
    }


    public RecordSet getDetalle(){
        return detalle;
    }

}