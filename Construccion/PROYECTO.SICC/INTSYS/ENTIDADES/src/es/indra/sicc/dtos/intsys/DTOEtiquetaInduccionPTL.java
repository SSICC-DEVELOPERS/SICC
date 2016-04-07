/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

/**
 * Sistema:		Belcorp
 * Modulo:	   	INT 
 * Fecha:		19/01/2007
 * @version		1.0
 * @autor		SPLATAS
 */
 
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;

public class DTOEtiquetaInduccionPTL extends DTOBelcorp
{
    private Long nroSolicitud;
    private Long nroCaja;
    private Long nroTotalCajas;
    private String tipoCaja;
    private String codImpresora;
    
    // Cambio APE-04 - dmorello, 10/01/2008
    private Long numeroCajaPTLActual;

    public DTOEtiquetaInduccionPTL()
    {
    }

    public Long getNroSolicitud()
    {
        return nroSolicitud;
    }

    public void setNroSolicitud(Long nroSolicitud)
    {
        this.nroSolicitud = nroSolicitud;
    }

    public Long getNroCaja()
    {
        return nroCaja;
    }

    public void setNroCaja(Long nroCaja)
    {
        this.nroCaja = nroCaja;
    }

    public Long getNroTotalCajas()
    {
        return nroTotalCajas;
    }

    public void setNroTotalCajas(Long nroTotalCajas)
    {
        this.nroTotalCajas = nroTotalCajas;
    }

    public String getTipoCaja()
    {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja)
    {
        this.tipoCaja = tipoCaja;
    }

    public String getCodImpresora()
    {
        return codImpresora;
    }

    public void setCodImpresora(String codImpresora)
    {
        this.codImpresora = codImpresora;
    }

  public Long getNumeroCajaPTLActual()
  {
    return numeroCajaPTLActual;
  }

  public void setNumeroCajaPTLActual(Long numeroCajaPTLActual)
  {
    this.numeroCajaPTLActual = numeroCajaPTLActual;
  }
}