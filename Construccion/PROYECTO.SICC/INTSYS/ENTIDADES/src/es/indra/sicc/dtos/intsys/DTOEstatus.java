/**
 * Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */



package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOEstatus extends DTOBelcorp 
{
    public DTOEstatus()
    {
    }
    private Long oidEstatus;   
    private String cadena;     
    private String numeroLote; 

    public String getCadena()
    {
        return cadena;
    }

    public void setCadena(String cadena)
    {
        this.cadena = cadena;
    }

    public String getNumeroLote()
    {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote)
    {
        this.numeroLote = numeroLote;
    }

    public Long getOidEstatus()
    {
        return oidEstatus;
    }

    public void setOidEstatus(Long oidEstatus)
    {
        this.oidEstatus = oidEstatus;
    }

}