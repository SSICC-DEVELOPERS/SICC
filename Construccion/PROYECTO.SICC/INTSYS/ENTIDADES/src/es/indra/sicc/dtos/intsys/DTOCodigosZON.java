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

public class DTOCodigosZON extends DTOBelcorp{
    public DTOCodigosZON()
    {
    }
    
    private String subgerencia;
    private String region;
    private String zona;
    private String seccion;
    private Long territorio;
    private String nivelCambio;

    public String getNivelCambio()
    {
        return nivelCambio;
    }

    public void setNivelCambio(String nivelCambio)
    {
        this.nivelCambio = nivelCambio;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getSeccion()
    {
        return seccion;
    }

    public void setSeccion(String seccion)
    {
        this.seccion = seccion;
    }

    public String getSubgerencia()
    {
        return subgerencia;
    }

    public void setSubgerencia(String subgerencia)
    {
        this.subgerencia = subgerencia;
    }

    public Long getTerritorio()
    {
        return territorio;
    }

    public void setTerritorio(Long territorio)
    {
        this.territorio = territorio;
    }

    public String getZona()
    {
        return zona;
    }

    public void setZona(String zona)
    {
        this.zona = zona;
    }
    
}