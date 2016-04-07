/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.cra;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Timestamp;

public class DTOCronogramaFecha extends DTOAuditableSICC{
  private Timestamp fechaIni;
  private Timestamp fechaFin;

  public DTOCronogramaFecha(){}

  public Timestamp getFechaIni()
  {
    return fechaIni;
  }

  public void setFechaIni(Timestamp newFechaIni)
  {
    fechaIni = newFechaIni;
  }

  public Timestamp getFechaFin()
  {
    return fechaFin;
  }

  public void setFechaFin(Timestamp newFechaFin)
  {
    fechaFin = newFechaFin;
  }
  
}