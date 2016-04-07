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
import java.math.BigDecimal;

public class DTOVolumenProducto extends DTOBelcorp  {
  private Long oidProducto;
  private Long oidUnidadMedidaVolumen;
  private BigDecimal volumen;
  private Integer unidadesProducto;
  // vbongiov -- 3/5/2007 -- Peticion de cambio 10
  private Integer numeroOrdenBalanceo;
  
  // sapaza -- Cambios para WCS y MUO -- 22/09/2010
  private String codigoSistemaPicado;
  private Integer numeroUnidadesCajaMaestra;
  private BigDecimal porcentajeCubicajeAdicional;
  private Long oidTipoCajaMaestra;
  private String descripcionTipoCajaMaestra;

  public DTOVolumenProducto() {
  }

  public Long getOidProducto() {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }

  public Long getOidUnidadMedidaVolumen() {
    return oidUnidadMedidaVolumen;
  }

  public void setOidUnidadMedidaVolumen(Long oidUnidadMedidaVolumen) {
    this.oidUnidadMedidaVolumen = oidUnidadMedidaVolumen;
  }

  public BigDecimal getVolumen() {
    return volumen;
  }

  public void setVolumen(BigDecimal volumen) {
    this.volumen = volumen;
  }

  public Integer getUnidadesProducto() {
    return unidadesProducto;
  }

  public void setUnidadesProducto(Integer unidadesProducto) {
    this.unidadesProducto = unidadesProducto;
  }

  public Integer getNumeroOrdenBalanceo() {
    return numeroOrdenBalanceo;
  }

  public void setNumeroOrdenBalanceo(Integer numeroOrdenBalanceo) {
    this.numeroOrdenBalanceo = numeroOrdenBalanceo;
  }

    public void setCodigoSistemaPicado(String codigoSistemaPicado) {
        this.codigoSistemaPicado = codigoSistemaPicado;
    }

    public String getCodigoSistemaPicado() {
        return codigoSistemaPicado;
    }

    public void setNumeroUnidadesCajaMaestra(Integer numeroUnidadesCajaMaestra) {
        this.numeroUnidadesCajaMaestra = numeroUnidadesCajaMaestra;
    }

    public Integer getNumeroUnidadesCajaMaestra() {
        return numeroUnidadesCajaMaestra;
    }

    public void setPorcentajeCubicajeAdicional(BigDecimal porcentajeCubicajeAdicional) {
        this.porcentajeCubicajeAdicional = porcentajeCubicajeAdicional;
    }

    public BigDecimal getPorcentajeCubicajeAdicional() {
        return porcentajeCubicajeAdicional;
    }

    public void setOidTipoCajaMaestra(Long oidTipoCajaMaestra) {
        this.oidTipoCajaMaestra = oidTipoCajaMaestra;
    }

    public Long getOidTipoCajaMaestra() {
        return oidTipoCajaMaestra;
    }

    public void setDescripcionTipoCajaMaestra(String descripcionTipoCajaMaestra) {
        this.descripcionTipoCajaMaestra = descripcionTipoCajaMaestra;
    }

    public String getDescripcionTipoCajaMaestra() {
        return descripcionTipoCajaMaestra;
    }
}
