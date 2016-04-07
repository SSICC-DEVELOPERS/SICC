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

public class DTOSBuscarProductos extends DTOAuditableSICC 
{
  private Long oidMoneda;
  private Long descripcionMoneda;
  private RecordSet productos;
  private RecordSet ciclosVida;
  private RecordSet tiposOferta;
  private RecordSet condicionPromocion;

  public DTOSBuscarProductos()
  {
  }

  public Long getOidMoneda()
  {
    return oidMoneda;
  }

  public void setOidMoneda(Long newOidMoneda)
  {
    oidMoneda = newOidMoneda;
  }

  public Long getDescripcionMoneda()
  {
    return descripcionMoneda;
  }

  public void setDescripcionMoneda(Long newDescripcionMoneda)
  {
    descripcionMoneda = newDescripcionMoneda;
  }

  public RecordSet getProductos()
  {
    return productos;
  }

  public void setProductos(RecordSet newProductos)
  {
    productos = newProductos;
  }

  public RecordSet getCiclosVida()
  {
    return ciclosVida;
  }

  public void setCiclosVida(RecordSet newCiclosVida)
  {
    ciclosVida = newCiclosVida;
  }

  public RecordSet getTiposOferta()
  {
    return tiposOferta;
  }

  public void setTiposOferta(RecordSet newTiposOferta)
  {
    tiposOferta = newTiposOferta;
  }

  public RecordSet getCondicionPromocion()
  {
    return condicionPromocion;
  }

  public void setCondicionPromocion(RecordSet newCondicionPromocion)
  {
    condicionPromocion = newCondicionPromocion;
  }
}