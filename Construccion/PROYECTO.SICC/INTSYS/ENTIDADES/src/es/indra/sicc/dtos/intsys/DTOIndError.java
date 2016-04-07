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

public class DTOIndError extends DTOBelcorp 
{
    public DTOIndError()
    {
    }
    
    private Long indLog;       
    private String  estado;    
    private String numeroLote; 

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public Long getIndLog()
    {
        return indLog;
    }

    public void setIndLog(Long indLog)
    {
        this.indLog = indLog;
    }

    public String getNumeroLote()
    {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote)
    {
        this.numeroLote = numeroLote;
    }

}