/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;

public class DTORegistroAbastecimientoDetalle extends DTOBelcorp {

  public DTORegistroAbastecimientoDetalle(){
  
    super();
  }
  
    private Long oid;   
    private Integer numeroLinea;   
    private Long stockMinimo;     
    private Long stockMaximo;   
    private Long unidadesEnviadas;   
    private Long unidadesConfirmadas;   
    private Long unidadesAtendidas;   
    private Long oidRegistroAbastecimientoCabecera;   
    private Long oidProducto;   
    private String codigoSAP;   
    private String descripcionCorta;   
    private Long oidTipoActuacion; 

  public String getCodigoSAP()
  {
    return codigoSAP;
  }

  public void setCodigoSAP(String codigoSAP)
  {
    this.codigoSAP = codigoSAP;
  }

  public String getDescripcionCorta()
  {
    return descripcionCorta;
  }

  public void setDescripcionCorta(String descripcionCorta)
  {
    this.descripcionCorta = descripcionCorta;
  }

  public Integer getNumeroLinea()
  {
    return numeroLinea;
  }

  public void setNumeroLinea(Integer numeroLinea)
  {
    this.numeroLinea = numeroLinea;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public Long getOidRegistroAbastecimientoCabecera()
  {
    return oidRegistroAbastecimientoCabecera;
  }

  public void setOidRegistroAbastecimientoCabecera(Long oidRegistroAbastecimientoCabecera)
  {
    this.oidRegistroAbastecimientoCabecera = oidRegistroAbastecimientoCabecera;
  }

  public Long getOidTipoActuacion()
  {
    return oidTipoActuacion;
  }

  public void setOidTipoActuacion(Long oidTipoActuacion)
  {
    this.oidTipoActuacion = oidTipoActuacion;
  }

  public Long getStockMaximo()
  {
    return stockMaximo;
  }

  public void setStockMaximo(Long stockMaximo)
  {
    this.stockMaximo = stockMaximo;
  }

  public Long getStockMinimo()
  {
    return stockMinimo;
  }

  public void setStockMinimo(Long stockMinimo)
  {
    this.stockMinimo = stockMinimo;
  }

  public Long getUnidadesAtendidas()
  {
    return unidadesAtendidas;
  }

  public void setUnidadesAtendidas(Long unidadesAtendidas)
  {
    this.unidadesAtendidas = unidadesAtendidas;
  }

  public Long getUnidadesConfirmadas()
  {
    return unidadesConfirmadas;
  }

  public void setUnidadesConfirmadas(Long unidadesConfirmadas)
  {
    this.unidadesConfirmadas = unidadesConfirmadas;
  }

  public Long getUnidadesEnviadas()
  {
    return unidadesEnviadas;
  }

  public void setUnidadesEnviadas(Long unidadesEnviadas)
  {
    this.unidadesEnviadas = unidadesEnviadas;
  }
}