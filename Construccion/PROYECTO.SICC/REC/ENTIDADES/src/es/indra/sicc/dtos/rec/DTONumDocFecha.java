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
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTONumDocFecha extends DTOBelcorp
{


private String numDocumento;   
private Date fechaGenerar;


    public DTONumDocFecha()
    {
    }

    public Date getFechaGenerar()
    {
        return fechaGenerar;
    }

    public void setFechaGenerar(Date fechaGenerar)
    {
        this.fechaGenerar = fechaGenerar;
    }

    public String getNumDocumento()
    {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento)
    {
        this.numDocumento = numDocumento;
    }
}