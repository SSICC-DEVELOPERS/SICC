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
 *
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.ape;
import java.sql.Timestamp;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTODatosCajaCabecera extends DTOBelcorp {
  private Long oidEtiqueta;
  private Long oidListaPicadoCabecera;
  private Long numeroConsolidado;
  private Long turnoChequeo;
  private String estadoPedido;
  private String estadoCaja;
  private Long numeroCaja;
  private Long totalCajas;
  private Long oidTipoCajaEmbalaje;
  private String origenChequeo;
  private Long totalProductos;
  private Long unidadesCaja;
  private Long unidadesPicadas;
  private Timestamp horaInicioChequeo;
  private Timestamp horaFinChequeo;
  private String usuarioChequeador;
  private ArrayList detalles;
  private String tipoChequeo;
  
  /* BELC400000722 - dmorello, 12/09/2007 */
  private Long oidPeriodo;

  public DTODatosCajaCabecera() {
  }

  public Long getOidEtiqueta() {
    return oidEtiqueta;
  }

  public void setOidEtiqueta(Long oidEtiqueta) {
    this.oidEtiqueta = oidEtiqueta;
  }

  public Long getOidListaPicadoCabecera() {
    return oidListaPicadoCabecera;
  }

  public void setOidListaPicadoCabecera(Long oidListaPicadoCabecera) {
    this.oidListaPicadoCabecera = oidListaPicadoCabecera;
  }

  public Long getNumeroConsolidado() {
    return numeroConsolidado;
  }

  public void setNumeroConsolidado(Long numeroConsolidado) {
    this.numeroConsolidado = numeroConsolidado;
  }

  public Long getTurnoChequeo() {
    return turnoChequeo;
  }

  public void setTurnoChequeo(Long turnoChequeo) {
    this.turnoChequeo = turnoChequeo;
  }

  public String getEstadoPedido() {
    return estadoPedido;
  }

  public void setEstadoPedido(String estadoPedido) {
    this.estadoPedido = estadoPedido;
  }

  public String getEstadoCaja() {
    return estadoCaja;
  }

  public void setEstadoCaja(String estadoCaja) {
    this.estadoCaja = estadoCaja;
  }

  public Long getNumeroCaja() {
    return numeroCaja;
  }

  public void setNumeroCaja(Long numeroCaja) {
    this.numeroCaja = numeroCaja;
  }

  public Long getTotalCajas() {
    return totalCajas;
  }

  public void setTotalCajas(Long totalCajas) {
    this.totalCajas = totalCajas;
  }

  public Long getOidTipoCajaEmbalaje() {
    return oidTipoCajaEmbalaje;
  }

  public void setOidTipoCajaEmbalaje(Long oidTipoCajaEmbalaje) {
    this.oidTipoCajaEmbalaje = oidTipoCajaEmbalaje;
  }

  public String getOrigenChequeo() {
    return origenChequeo;
  }

  public void setOrigenChequeo(String origenChequeo) {
    this.origenChequeo = origenChequeo;
  }

  public Long getTotalProductos() {
    return totalProductos;
  }

  public void setTotalProductos(Long totalProductos) {
    this.totalProductos = totalProductos;
  }

  public Long getUnidadesCaja() {
    return unidadesCaja;
  }

  public void setUnidadesCaja(Long unidadesCaja) {
    this.unidadesCaja = unidadesCaja;
  }

  public Long getUnidadesPicadas() {
    return unidadesPicadas;
  }

  public void setUnidadesPicadas(Long unidadesPicadas) {
    this.unidadesPicadas = unidadesPicadas;
  }

  public Timestamp getHoraInicioChequeo() {
    return horaInicioChequeo;
  }

  public void setHoraInicioChequeo(Timestamp horaInicioChequeo) {
    this.horaInicioChequeo = horaInicioChequeo;
  }

  public Timestamp getHoraFinChequeo() {
    return horaFinChequeo;
  }

  public void setHoraFinChequeo(Timestamp horaFinChequeo) {
    this.horaFinChequeo = horaFinChequeo;
  }

  public String getUsuarioChequeador() {
    return usuarioChequeador;
  }

  public void setUsuarioChequeador(String usuarioChequeador) {
    this.usuarioChequeador = usuarioChequeador;
  }

  public ArrayList getDetalles() {
    return detalles;
  }

  public void setDetalles(ArrayList detalles) {
    this.detalles = detalles;
  }

  public String getTipoChequeo() {
    return tipoChequeo;
  }

  public void setTipoChequeo(String tipoChequeo) {
    this.tipoChequeo = tipoChequeo;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }
}