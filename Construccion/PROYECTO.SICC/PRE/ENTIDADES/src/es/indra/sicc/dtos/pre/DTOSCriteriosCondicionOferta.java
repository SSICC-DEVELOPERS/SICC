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

public class DTOSCriteriosCondicionOferta extends DTOAuditableSICC 
{
  private RecordSet indicadoresCuadre;
  private RecordSet catalogos;

  public DTOSCriteriosCondicionOferta()
  {
  }

  public RecordSet getIndicadoresCuadre()
  {
    return indicadoresCuadre;
  }

  public void setIndicadoresCuadre(RecordSet newIndicadoresCuadre)
  {
    indicadoresCuadre = newIndicadoresCuadre;
  }

  public RecordSet getCatalogos()
  {
    return catalogos;
  }

  public void setCatalogos(RecordSet newCatalogos)
  {
    catalogos = newCatalogos;
  }
}