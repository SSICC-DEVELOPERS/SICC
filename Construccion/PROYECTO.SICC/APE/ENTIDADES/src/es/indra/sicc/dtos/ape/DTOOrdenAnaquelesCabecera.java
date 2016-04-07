
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
 */package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Vector;

public class DTOOrdenAnaquelesCabecera extends DTOBelcorp  {

    private Long oid;
    private Long codigoMapaOrden;
    private Vector descripcionOrdenAnaqueles;
    private String descOrdenAnaqueles;
    private Boolean valorDefecto;
    private DTOMapaZonasCabecera mapaZonaCabecera;
    private DTOSublineaArmado sublineaArmado;
    
  public DTOOrdenAnaquelesCabecera() {
  }


  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setCodigoMapaOrden(Long codigoMapaOrden) {
    this.codigoMapaOrden = codigoMapaOrden;
  }


  public Long getCodigoMapaOrden() {
    return codigoMapaOrden;
  }

  public void setValorDefecto(Boolean valorDefecto) {
    this.valorDefecto = valorDefecto;
  }


  public Boolean getValorDefecto() {
    return valorDefecto;
  }


  public void setMapaZonaCabecera(DTOMapaZonasCabecera mapaZonaCabecera) {
    this.mapaZonaCabecera = mapaZonaCabecera;
  }


  public DTOMapaZonasCabecera getMapaZonaCabecera() {
    return mapaZonaCabecera;
  }


  public void setSublineaArmado(DTOSublineaArmado sublineaArmado) {
    this.sublineaArmado = sublineaArmado;
  }


  public DTOSublineaArmado getSublineaArmado() {
    return sublineaArmado;
  }


  public void setDescripcionOrdenAnaqueles(Vector descripcionOrdenAnaqueles) {
    this.descripcionOrdenAnaqueles = descripcionOrdenAnaqueles;
  }


  public Vector getDescripcionOrdenAnaqueles() {
    return descripcionOrdenAnaqueles;
  }


  public void setDescOrdenAnaqueles(String descOrdenAnaqueles) {
    this.descOrdenAnaqueles = descOrdenAnaqueles;
  }


  public String getDescOrdenAnaqueles() {
    return descOrdenAnaqueles;
  }
}