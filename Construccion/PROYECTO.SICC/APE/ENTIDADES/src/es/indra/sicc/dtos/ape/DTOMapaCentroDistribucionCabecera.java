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
import java.util.Vector;

public class DTOMapaCentroDistribucionCabecera extends DTOBelcorp  {
  private Long oid;
  private Long codigoMapa;
  private String descripcionMapa;
  private Boolean valorDefecto;
  private DTOConfiguracionCentroDistribucion centroDistribucion;
  private Vector attriTraducible;   

  public DTOMapaCentroDistribucionCabecera() {  }
  
  public Vector getAttriTraducible() {
    return attriTraducible;
  }

  public void setAttriTraducible(Vector attriTraducible) {
    this.attriTraducible = attriTraducible;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getOid() {
    return oid;
  }

  public void setCodigoMapa(Long codigoMapa) {
    this.codigoMapa = codigoMapa;
  }

  public Long getCodigoMapa() {
    return codigoMapa;
  }

  public void setDescripcionMapa(String descripcionMapa) {
    this.descripcionMapa = descripcionMapa;
  }

  public String getDescripcionMapa() {
    return descripcionMapa;
  }

  public void setValorDefecto(Boolean valorDefecto) {
    this.valorDefecto = valorDefecto;
  }

  public Boolean getValorDefecto() {
    return valorDefecto;
  }

  public DTOConfiguracionCentroDistribucion getCentroDistribucion() {
    return centroDistribucion;
  }

  public void setCentroDistribucion(DTOConfiguracionCentroDistribucion centroDistribucion) {
    this.centroDistribucion = centroDistribucion;
  }
}