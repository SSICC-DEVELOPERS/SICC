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

/**
 * 
 * pperanzola - 20/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
 */
public class DTOLineaPromocion extends DTOAuditableSICC 
{
  private Long oidLineaPromocion;
  private Long oidCatalogo;
  private String descripcionCatalogo;
  private char tipoRango;
  private Integer numeroRangoInterno;
  private Boolean indicadorExclusion;
  private String valorDesde;
  private String valorHasta;
  private String descripcionLineaProducto;
  private String descripcionProducto;
  private String codigoProducto;
  private String codigoLineaProducto;
  private String tipoOperacion;//[1]

  public DTOLineaPromocion()
  {
  }

  public Long getOidLineaPromocion()
  {
    return oidLineaPromocion;
  }

  public void setOidLineaPromocion(Long newOidLineaPromocion)
  {
    oidLineaPromocion = newOidLineaPromocion;
  }

  public Long getOidCatalogo()
  {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long newOidCatalogo)
  {
    oidCatalogo = newOidCatalogo;
  }

  public String getDescripcionCatalogo()
  {
    return descripcionCatalogo;
  }

  public void setDescripcionCatalogo(String newDescripcionCatalogo)
  {
    descripcionCatalogo = newDescripcionCatalogo;
  }

  public char getTipoRango()
  {
    return tipoRango;
  }

  public void setTipoRango(char newTipoRango)
  {
    tipoRango = newTipoRango;
  }

  public Integer getNumeroRangoInterno()
  {
    return numeroRangoInterno;
  }

  public void setNumeroRangoInterno(Integer newNumeroRangoInterno)
  {
    numeroRangoInterno = newNumeroRangoInterno;
  }

  public Boolean getIndicadorExclusion()
  {
    return indicadorExclusion;
  }

  public void setIndicadorExclusion(Boolean newIndicadorExclusion)
  {
    indicadorExclusion = newIndicadorExclusion;
  }

  public String getValorDesde()
  {
    return valorDesde;
  }

  public void setValorDesde(String newValorDesde)
  {
    valorDesde = newValorDesde;
  }

  public String getValorHasta()
  {
    return valorHasta;
  }

  public void setValorHasta(String newValorHasta)
  {
    valorHasta = newValorHasta;
  }

  public String getDescripcionLineaProducto()
  {
    return descripcionLineaProducto;
  }

  public void setDescripcionLineaProducto(String newDescripcionLineaProducto)
  {
    descripcionLineaProducto = newDescripcionLineaProducto;
  }

  public String getDescripcionProducto()
  {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String newDescripcionProducto)
  {
    descripcionProducto = newDescripcionProducto;
  }

  public String getCodigoProducto()
  {
    return codigoProducto;
  }

  public void setCodigoProducto(String newCodigoProducto)
  {
    codigoProducto = newCodigoProducto;
  }

  public String getCodigoLineaProducto() {
    return codigoLineaProducto;
  }

  public void setCodigoLineaProducto(String newCodigoLineaProducto) {
    codigoLineaProducto = newCodigoLineaProducto;
  }
  ///*[1]
  public String getTipoOperacion() {
        return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion){
        this.tipoOperacion = tipoOperacion;
  }
  //*/[1]  
}