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
 *
 */

package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOAsignacionImpresorasAPE extends DTOBelcorp
{

    private Long impresoraVirtual;
    private Long tecnologia;
    private Long subLinea;
    private Long nroImpresoraPTL;

  public DTOAsignacionImpresorasAPE()
  {
  }


  public void setImpresoraVirtual(Long impresoraVirtual)
  {
    this.impresoraVirtual = impresoraVirtual;
  }


  public Long getImpresoraVirtual()
  {
    return impresoraVirtual;
  }


  public void setTecnologia(Long tecnologia)
  {
    this.tecnologia = tecnologia;
  }


  public Long getTecnologia()
  {
    return tecnologia;
  }


  public void setSubLinea(Long subLinea)
  {
    this.subLinea = subLinea;
  }


  public Long getSubLinea()
  {
    return subLinea;
  }


  public void setNroImpresoraPTL(Long nroImpresoraPTL)
  {
    this.nroImpresoraPTL = nroImpresoraPTL;
  }


  public Long getNroImpresoraPTL()
  {
    return nroImpresoraPTL;
  }
}