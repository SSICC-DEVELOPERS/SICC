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
 */ 
 
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

import java.util.Date;

public class DTOEtiqueta extends DTOBelcorp 
{
  private Long numeroCaja;
  private Long numeroTotalCajas;
  private Long centroDistribucion;
  private Long listaPicado;
  private Long solicitudCabecera;
  private Integer longitudNumeroEtiqueta;
  private Long secuencial;
  private Long tipoCajaEmbalaje;
  private String textoChequeo;
  private String textoPrimerPedido;
  private String textoVariable;
  private Long seccion;
  private Long zona;
  private Long estadoPedido;
  private Long numeroConsolidado;
  private String campania;
  private String cargo;
  private Long codigoListaPicado;
  private String codigoSeccion;
  private String compania;
  private Long indicadorChequeo;
  private String codigoRegion;
  private String talla;
  private String codigoZona;
  private String region;
  private Long oidEtiqueta;
  private String formatoEtiqueta;
  private Long oidCliente;
  private Long oidSublineaArmado;
  private Integer numeroEtiquetasCaja;
  private String codigoImpresora;
  private Boolean indImprimirDatosBasicosCliente;
  private Date fechaFacturacion;
  private String descripcionLineaArmado;

  public DTOEtiqueta()
  {
  }

  public Long getNumeroCaja()
  {
    return numeroCaja;
  }

  public void setNumeroCaja(Long numeroCaja)
  {
    this.numeroCaja = numeroCaja;
  }

  public Long getNumeroTotalCajas()
  {
    return numeroTotalCajas;
  }

  public void setNumeroTotalCajas(Long numeroTotalCajas)
  {
    this.numeroTotalCajas = numeroTotalCajas;
  }

  public Long getCentroDistribucion()
  {
    return centroDistribucion;
  }

  public void setCentroDistribucion(Long centroDistribucion)
  {
    this.centroDistribucion = centroDistribucion;
  }

  public Long getListaPicado()
  {
    return listaPicado;
  }

  public void setListaPicado(Long listaPicado)
  {
    this.listaPicado = listaPicado;
  }

  public Long getSolicitudCabecera()
  {
    return solicitudCabecera;
  }

  public void setSolicitudCabecera(Long solicitudCabecera)
  {
    this.solicitudCabecera = solicitudCabecera;
  }

  public Integer getLongitudNumeroEtiqueta()
  {
    return longitudNumeroEtiqueta;
  }

  public void setLongitudNumeroEtiqueta(Integer longitudNumeroEtiqueta)
  {
    this.longitudNumeroEtiqueta = longitudNumeroEtiqueta;
  }

  public Long getSecuencial()
  {
    return secuencial;
  }

  public void setSecuencial(Long secuencial)
  {
    this.secuencial = secuencial;
  }

  public Long getTipoCajaEmbalaje()
  {
    return tipoCajaEmbalaje;
  }

  public void setTipoCajaEmbalaje(Long tipoCajaEmbalaje)
  {
    this.tipoCajaEmbalaje = tipoCajaEmbalaje;
  }

  public String getTextoChequeo()
  {
    return textoChequeo;
  }

  public void setTextoChequeo(String textoChequeo)
  {
    this.textoChequeo = textoChequeo;
  }

  public String getTextoPrimerPedido()
  {
    return textoPrimerPedido;
  }

  public void setTextoPrimerPedido(String textoPrimerPedido)
  {
    this.textoPrimerPedido = textoPrimerPedido;
  }

  public String getTextoVariable()
  {
    return textoVariable;
  }

  public void setTextoVariable(String textoVariable)
  {
    this.textoVariable = textoVariable;
  }

  public Long getSeccion()
  {
    return seccion;
  }

  public void setSeccion(Long seccion)
  {
    this.seccion = seccion;
  }

  public Long getZona()
  {
    return zona;
  }

  public void setZona(Long zona)
  {
    this.zona = zona;
  }

  public Long getEstadoPedido()
  {
    return estadoPedido;
  }

  public void setEstadoPedido(Long estadoPedido)
  {
    this.estadoPedido = estadoPedido;
  }

  public Long getNumeroConsolidado()
  {
    return numeroConsolidado;
  }

  public void setNumeroConsolidado(Long numeroConsolidado)
  {
    this.numeroConsolidado = numeroConsolidado;
  }

  public String getCampania()
  {
    return campania;
  }

  public void setCampania(String campania)
  {
    this.campania = campania;
  }

  public String getCargo()
  {
    return cargo;
  }

  public void setCargo(String cargo)
  {
    this.cargo = cargo;
  }

  public Long getCodigoListaPicado()
  {
    return codigoListaPicado;
  }

  public void setCodigoListaPicado(Long codigoListaPicado)
  {
    this.codigoListaPicado = codigoListaPicado;
  }

  public String getCodigoSeccion()
  {
    return codigoSeccion;
  }

  public void setCodigoSeccion(String codigoSeccion)
  {
    this.codigoSeccion = codigoSeccion;
  }

  public String getCompania()
  {
    return compania;
  }

  public void setCompania(String compania)
  {
    this.compania = compania;
  }

  public Long getIndicadorChequeo()
  {
    return indicadorChequeo;
  }

  public void setIndicadorChequeo(Long indicadorChequeo)
  {
    this.indicadorChequeo = indicadorChequeo;
  }

  public String getCodigoRegion()
  {
    return codigoRegion;
  }

  public void setCodigoRegion(String codigoRegion)
  {
    this.codigoRegion = codigoRegion;
  }

  public String getTalla()
  {
    return talla;
  }

  public void setTalla(String talla)
  {
    this.talla = talla;
  }

  public String getCodigoZona()
  {
    return codigoZona;
  }

  public void setCodigoZona(String codigoZona)
  {
    this.codigoZona = codigoZona;
  }

  public String getRegion()
  {
    return region;
  }

  public void setRegion(String region)
  {
    this.region = region;
  }

  public Long getOidEtiqueta()
  {
    return oidEtiqueta;
  }

  public void setOidEtiqueta(Long oidEtiqueta)
  {
    this.oidEtiqueta = oidEtiqueta;
  }

  public String getFormatoEtiqueta()
  {
    return formatoEtiqueta;
  }

  public void setFormatoEtiqueta(String formatoEtiqueta)
  {
    this.formatoEtiqueta = formatoEtiqueta;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidSublineaArmado()
  {
    return oidSublineaArmado;
  }

  public void setOidSublineaArmado(Long oidSublineaArmado)
  {
    this.oidSublineaArmado = oidSublineaArmado;
  }

  public Integer getNumeroEtiquetasCaja()
  {
    return numeroEtiquetasCaja;
  }

  public void setNumeroEtiquetasCaja(Integer numeroEtiquetasCaja)
  {
    this.numeroEtiquetasCaja = numeroEtiquetasCaja;
  }

  public String getCodigoImpresora()
  {
    return codigoImpresora;
  }

  public void setCodigoImpresora(String codigoImpresora)
  {
    this.codigoImpresora = codigoImpresora;
  }

  public void setIndImprimirDatosBasicosCliente(Boolean indImprimirDatosBasicosCliente) {
    this.indImprimirDatosBasicosCliente = indImprimirDatosBasicosCliente;
  }

  public Boolean getIndImprimirDatosBasicosCliente() {
    return indImprimirDatosBasicosCliente;
  }

  public void setFechaFacturacion(Date fechaFacturacion) {
      this.fechaFacturacion = fechaFacturacion;
  }

  public Date getFechaFacturacion() {
      return fechaFacturacion;
  }

  public void setDescripcionLineaArmado(String descripcionLineaArmado) {
      this.descripcionLineaArmado = descripcionLineaArmado;
  }

  public String getDescripcionLineaArmado() {
      return descripcionLineaArmado;
  }
}
