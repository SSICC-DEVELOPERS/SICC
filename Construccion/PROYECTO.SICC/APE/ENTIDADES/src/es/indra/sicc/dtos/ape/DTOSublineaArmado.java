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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOOIDs;
import java.util.Vector;

// Gpons - 10/03/2007 - Inc. BELC400000337: Se elimina SistemaEtiquetado
// GPons - 16/03/2007 - Inc. BELC400000340: Se agrega centroDistribucion

public class DTOSublineaArmado extends DTOSiccPaginacion {

  private Long oid;
  private Long codigoSublinea;
  private String descripcionSublinea;
  private Boolean postVenta;
  private char letraParaAnaquel;
  private Boolean imprimirListaPicado;
  private Boolean frenteEspalda;
  private Integer bahiasFrente;
  private Integer bahiaEspalda;
  private Integer numeroNivelesFrente;
  private Integer numeroNivelesEspalda;
  private Integer numeroColumnasFrente;
  private Integer numeroColumnasEspalda;
      
  private Long numeroOrdenBalanceo;
    
  private DTOLineaArmado lineaArmado;
  private DTOSistemaPicado sistemaPicado;
  private Long centroDistribucion;
  
  private Vector attriTraducible; // descripcionSublinea  
  
  private Vector tipoCajaSublineas; 
  private DTOOIDs tipoCajaSublineasEliminados;
  
  private Long impresoraVirtual;
  private DTOAsignacionImpresorasAPE impresora;
   
  public DTOSublineaArmado() {
  }


  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setCodigoSublinea(Long codigoSublinea) {
    this.codigoSublinea = codigoSublinea;
  }
  public Long getCodigoSublinea() {
    return codigoSublinea;
  }


  public void setDescripcionSublinea(String descripcionSublinea) {
    this.descripcionSublinea = descripcionSublinea;
  }
  public String getDescripcionSublinea() {
    return descripcionSublinea;
  }


  public void setPostVenta(Boolean postVenta) {
    this.postVenta = postVenta;
  }
  public Boolean getPostVenta() {
    return postVenta;
  }


  public void setLetraParaAnaquel(char letraParaAnaquel) {
    this.letraParaAnaquel = letraParaAnaquel;
  }
  public char getLetraParaAnaquel() {
    return letraParaAnaquel;
  }


  public void setImprimirListaPicado(Boolean imprimirListaPicado) {
    this.imprimirListaPicado = imprimirListaPicado;
  }
  public Boolean getImprimirListaPicado() {
    return imprimirListaPicado;
  }


  public void setFrenteEspalda(Boolean frenteEspalda) {
    this.frenteEspalda = frenteEspalda;
  }
  public Boolean getFrenteEspalda() {
    return frenteEspalda;
  }


  public void setBahiasFrente(Integer bahiasFrente) {
    this.bahiasFrente = bahiasFrente;
  }
  public Integer getBahiasFrente() {
    return bahiasFrente;
  }


  public void setBahiaEspalda(Integer bahiaEspalda) {
    this.bahiaEspalda = bahiaEspalda;
  }
  public Integer getBahiaEspalda() {
    return bahiaEspalda;
  }


  public void setNumeroNivelesFrente(Integer numeroNivelesFrente) {
    this.numeroNivelesFrente = numeroNivelesFrente;
  }
  public Integer getNumeroNivelesFrente() {
    return numeroNivelesFrente;
  }


  public void setNumeroNivelesEspalda(Integer numeroNivelesEspalda) {
    this.numeroNivelesEspalda = numeroNivelesEspalda;
  }
  public Integer getNumeroNivelesEspalda() {
    return numeroNivelesEspalda;
  }


  public void setNumeroColumnasFrente(Integer numeroColumnasFrente) {
    this.numeroColumnasFrente = numeroColumnasFrente;
  }
  public Integer getNumeroColumnasFrente() {
    return numeroColumnasFrente;
  }


  public void setNumeroColumnasEspalda(Integer numeroColumnasEspalda) {
    this.numeroColumnasEspalda = numeroColumnasEspalda;
  }
  public Integer getNumeroColumnasEspalda() {
    return numeroColumnasEspalda;
  }

  public void setCentroDistribucion(Long centroDistribucion) {
    this.centroDistribucion = centroDistribucion;
  }
  public Long getCentroDistribucion() {
    return centroDistribucion;
  }

  public void setNumeroOrdenBalanceo(Long numeroOrdenBalanceo) {
    this.numeroOrdenBalanceo = numeroOrdenBalanceo;
  }
  public Long getNumeroOrdenBalanceo() {
    return numeroOrdenBalanceo;
  }

  public void setLineaArmado(DTOLineaArmado lineaArmado) {
    this.lineaArmado = lineaArmado;
  }
  public DTOLineaArmado getLineaArmado() {
    return lineaArmado;
  }


  public void setSistemaPicado(DTOSistemaPicado sistemaPicado) {
    this.sistemaPicado = sistemaPicado;
  }
  public DTOSistemaPicado getSistemaPicado() {
    return sistemaPicado;
  }

  public void setAttriTraducible(Vector attriTraducible) {
        this.attriTraducible = attriTraducible;
  }
  public Vector getAttriTraducible() {
        return attriTraducible;
  }

//---------------------------------------------------------------------

  public Vector getTipoCajaSublineas() {
    return tipoCajaSublineas;
  }

  public void setTipoCajaSublineas(Vector tipoCajaSublineas) {
    this.tipoCajaSublineas = tipoCajaSublineas;
  }

  public DTOOIDs getTipoCajaSublineasEliminados() {
    return tipoCajaSublineasEliminados;
           
  }

  public void setTipoCajaSublineasEliminados(DTOOIDs tiposCajaSublineaEliminados) {
    this.tipoCajaSublineasEliminados = tiposCajaSublineaEliminados;
  }

  public void setImpresoraVirtual(Long impresoraVirtual)
  {
    this.impresoraVirtual = impresoraVirtual;
  }


  public Long getImpresoraVirtual()
  {
    return impresoraVirtual;
  }


  public void setImpresora(DTOAsignacionImpresorasAPE impresora)
  {
    this.impresora = impresora;
  }


  public DTOAsignacionImpresorasAPE getImpresora()
  {
    return impresora;
  }

}