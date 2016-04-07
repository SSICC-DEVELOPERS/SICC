/**
 * Copyright 2008 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 */

package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOImpresionEtiquetasManual extends DTOBelcorp 
{
    private Long numConsolidado;
    private Long numCaja;

    public Long getNumConsolidado()
    {
        return numConsolidado;
    }

    public void setNumConsolidado(Long numConsolidado)
    {
        this.numConsolidado = numConsolidado;
    }

    public Long getNumCaja()
    {
        return numCaja;
    }

    public void setNumCaja(Long numCaja)
    {
        this.numCaja = numCaja;
    }
}