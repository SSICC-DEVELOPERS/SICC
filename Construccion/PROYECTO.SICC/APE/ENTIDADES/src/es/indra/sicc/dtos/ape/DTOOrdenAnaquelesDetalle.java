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

public class DTOOrdenAnaquelesDetalle extends DTOBelcorp  {

  private Long oid;
  private Long numeroOrden;
  private String numeroAnaquel;
  private DTOOrdenAnaquelesCabecera ordenAnaquelCabecera;
  private Long oidAnaquel;
  private String numeroAnaquelDestino;
  private String indExpandido;

  public DTOOrdenAnaquelesDetalle() {
  }


  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setNumeroOrden(Long numeroOrden) {
    this.numeroOrden = numeroOrden;
  }


  public Long getNumeroOrden() {
    return numeroOrden;
  }


  public void setNumeroAnaquel(String numeroAnaquel) {
    this.numeroAnaquel = numeroAnaquel;
  }


  public String getNumeroAnaquel() {
    return numeroAnaquel;
  }


  public void setOrdenAnaquelCabecera(DTOOrdenAnaquelesCabecera ordenAnaquelCabecera) {
    this.ordenAnaquelCabecera = ordenAnaquelCabecera;
  }


  public DTOOrdenAnaquelesCabecera getOrdenAnaquelCabecera() {
    return ordenAnaquelCabecera;
  }


  public void setOidAnaquel(Long oidAnaquel) {
    this.oidAnaquel = oidAnaquel;
  }


  public Long getOidAnaquel() {
    return oidAnaquel;
  }

  public String getNumeroAnaquelDestino() {
    return numeroAnaquelDestino;
  }

  public void setNumeroAnaquelDestino(String numeroAnquelDestino) {
    this.numeroAnaquelDestino = numeroAnquelDestino;
  }

  public String getIndExpandido() {
    return indExpandido;
  }

  public void setIndExpandido(String indExpandido) {
    this.indExpandido = indExpandido;
  }
}
