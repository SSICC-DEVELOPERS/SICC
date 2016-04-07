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
import es.indra.sicc.util.DTOOIDs;

public class DTOGestBoletasRecPend extends DTOBelcorp  {

    private String anularNoExitoso = null;
    private DTOOIDs oids = null;
    private DTOOIDs numsAten = null;
    private DTOOIDs oidNumRecoj = null;
    private DTOOIDs numBoletaRecojo = null;
    public DTOGestBoletasRecPend()
    {
    }


    public void setAnularNoExitoso(String anularNoExitoso)
    {
        this.anularNoExitoso = anularNoExitoso;
    }


    public String getAnularNoExitoso()
    {
        return anularNoExitoso;
    }


    public void setOids(DTOOIDs oids)
    {
        this.oids = oids;
    }


    public DTOOIDs getOids()
    {
        return oids;
    }


    public void setNumsAten(DTOOIDs numsAten)
    {
        this.numsAten = numsAten;
    }


    public DTOOIDs getNumsAten()
    {
        return numsAten;
    }
    // Agragado por cambio 2000765
    public void setOidNumRecoj(DTOOIDs oidNumRecoj)
    {
        this.oidNumRecoj = oidNumRecoj;
    }


    public DTOOIDs getOidNumRecoj()
    {
        return oidNumRecoj;
    }
    
    public void setNumBoletaRecojo(DTOOIDs numBoletaRecojo)
    {
        this.numBoletaRecojo = numBoletaRecojo;
    }


    public DTOOIDs getNumBoletaRecojo()
    {
        return numBoletaRecojo;
    }
}