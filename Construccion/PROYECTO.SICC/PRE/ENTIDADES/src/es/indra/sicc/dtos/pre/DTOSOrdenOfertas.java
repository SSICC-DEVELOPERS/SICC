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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOSOrdenOfertas extends DTOAuditableSICC 
{
  private RecordSet cabecera;
  private RecordSet detalle;

  public DTOSOrdenOfertas()
  {
  }

  public RecordSet getCabecera()
  {
    return cabecera;
  }

  public void setCabecera(RecordSet newCabecera)
  {
    cabecera = newCabecera;
  }

  public RecordSet getDetalle()
  {
    return detalle;
  }

  public void setDetalle(RecordSet newDetalle)
  {
    detalle = newDetalle;
  }
}