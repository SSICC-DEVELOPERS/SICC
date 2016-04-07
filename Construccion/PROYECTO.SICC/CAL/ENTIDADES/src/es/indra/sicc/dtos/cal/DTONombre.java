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

public class DTONombre extends DTOBelcorp
{
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String apellidoCasada;

    public DTONombre()
    {
    }

    public String getNombre1()
    {
        return nombre1;
    }

    public void setNombre1(String nombre1)
    {
        this.nombre1 = nombre1;
    }

    public String getNombre2()
    {
        return nombre2;
    }

    public void setNombre2(String nombre2)
    {
        this.nombre2 = nombre2;
    }

    public String getApellido1()
    {
        return apellido1;
    }

    public void setApellido1(String apellido1)
    {
        this.apellido1 = apellido1;
    }

    public String getApellido2()
    {
        return apellido2;
    }

    public void setApellido2(String apellido2)
    {
        this.apellido2 = apellido2;
    }

    public String getApellidoCasada()
    {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada)
    {
        this.apellidoCasada = apellidoCasada;
    }
}