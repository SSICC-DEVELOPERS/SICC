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
 *
 */
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOComprobarOrden extends DTOAuditableSICC 
{
  private Boolean ofertasOrdenadas;

  public DTOComprobarOrden()
  {
  }

  public Boolean getOfertasOrdenadas()
  {
    return ofertasOrdenadas;
  }

  public void setOfertasOrdenadas(Boolean newOfertasOrdenadas)
  {
    ofertasOrdenadas = newOfertasOrdenadas;
  }
}