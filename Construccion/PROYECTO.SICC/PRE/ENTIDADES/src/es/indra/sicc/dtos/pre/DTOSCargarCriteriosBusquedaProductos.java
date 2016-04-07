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

public class DTOSCargarCriteriosBusquedaProductos extends DTOAuditableSICC 
{
  private RecordSet catalogos;
  private RecordSet marcas;
  private RecordSet lineasProducto;
  private RecordSet unidadesNegocio;
  private RecordSet negocios;
  private RecordSet genericos;
  private RecordSet supergenericos;
  private RecordSet estrategias;

  public DTOSCargarCriteriosBusquedaProductos()
  {
  }

  public RecordSet getCatalogos()
  {
    return catalogos;
  }

  public void setCatalogos(RecordSet newCatalogos)
  {
    catalogos = newCatalogos;
  }

  public RecordSet getMarcas()
  {
    return marcas;
  }

  public void setMarcas(RecordSet newMarcas)
  {
    marcas = newMarcas;
  }

  public RecordSet getLineasProducto()
  {
    return lineasProducto;
  }

  public void setLineasProducto(RecordSet newLineasProducto)
  {
    lineasProducto = newLineasProducto;
  }

  public RecordSet getUnidadesNegocio()
  {
    return unidadesNegocio;
  }

  public void setUnidadesNegocio(RecordSet newUnidadesNegocio)
  {
    unidadesNegocio = newUnidadesNegocio;
  }

  public RecordSet getNegocios()
  {
    return negocios;
  }

  public void setNegocios(RecordSet newNegocios)
  {
    negocios = newNegocios;
  }

  public RecordSet getGenericos()
  {
    return genericos;
  }

  public void setGenericos(RecordSet newGenericos)
  {
    genericos = newGenericos;
  }

  public RecordSet getSupergenericos()
  {
    return supergenericos;
  }

  public void setSupergenericos(RecordSet newSupergenericos)
  {
    supergenericos = newSupergenericos;
  }

  public RecordSet getEstrategias()
  {
    return estrategias;
  }

  public void setEstrategias(RecordSet newEstrategias)
  {
    estrategias = newEstrategias;
  }

}