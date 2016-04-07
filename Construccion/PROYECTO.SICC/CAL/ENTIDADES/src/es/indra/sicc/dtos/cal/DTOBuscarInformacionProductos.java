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

package es.indra.sicc.dtos.cal;

import java.math.BigDecimal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarInformacionProductos extends DTOSiccPaginacion 
{
  private String codSAP;
  private String codAntiguo;
  private String descCorta;
  private String descSAP;
  private Integer productoServicio;
  private Long marcaProducto;
  private Long unidadesNegocio;
  private Long negocio;
  private Long linea;
  private String situacion;
  private Long estatusProducto;
  private BigDecimal precioCatalogo;
  private BigDecimal precioContable;

  public DTOBuscarInformacionProductos()
  {
  }

  public String getCodSAP()
  {
    return codSAP;
  }

  public void setCodSAP(String codSAP)
  {
    this.codSAP = codSAP;
  }

  public String getCodAntiguo()
  {
    return codAntiguo;
  }

  public void setCodAntiguo(String codAntiguo)
  {
    this.codAntiguo = codAntiguo;
  }

  public String getDescCorta()
  {
    return descCorta;
  }

  public void setDescCorta(String descCorta)
  {
    this.descCorta = descCorta;
  }

  public String getDescSAP()
  {
    return descSAP;
  }

  public void setDescSAP(String descSAP)
  {
    this.descSAP = descSAP;
  }

  public Integer getProductoServicio()
  {
    return productoServicio;
  }

  public void setProductoServicio(Integer productoServicio)
  {
    this.productoServicio = productoServicio;
  }

  public Long getMarcaProducto()
  {
    return marcaProducto;
  }

  public void setMarcaProducto(Long marcaProducto)
  {
    this.marcaProducto = marcaProducto;
  }

  public Long getUnidadesNegocio()
  {
    return unidadesNegocio;
  }

  public void setUnidadesNegocio(Long unidadesNegocio)
  {
    this.unidadesNegocio = unidadesNegocio;
  }

  public Long getNegocio()
  {
    return negocio;
  }

  public void setNegocio(Long negocio)
  {
    this.negocio = negocio;
  }

  public Long getLinea()
  {
    return linea;
  }

  public void setLinea(Long linea)
  {
    this.linea = linea;
  }

  public String getSituacion()
  {
    return situacion;
  }

  public void setSituacion(String situacion)
  {
    this.situacion = situacion;
  }

  public Long getEstatusProducto()
  {
    return estatusProducto;
  }

  public void setEstatusProducto(Long estatusProducto)
  {
    this.estatusProducto = estatusProducto;
  }

  public BigDecimal getPrecioCatalogo()
  {
    return precioCatalogo;
  }





  public void setPrecioCatalogo(BigDecimal precioCatalogo) 
  {
    this.precioCatalogo = precioCatalogo;
  }

  public BigDecimal getPrecioContable()
  {
    return precioContable;
  }

  public void setPrecioContable(BigDecimal precioContable)
  {
    this.precioContable = precioContable;
  }
}