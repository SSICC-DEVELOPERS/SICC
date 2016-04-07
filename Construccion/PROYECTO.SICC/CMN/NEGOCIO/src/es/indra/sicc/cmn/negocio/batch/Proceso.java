/*
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

package es.indra.sicc.cmn.negocio.batch;

import java.util.Date;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Proceso {

  private String codigo;
  private String thread;
  private String usuario;
  private Integer estado;
  private Date fechaEncolado;
  private Date fechaInicio;
  private Date fechaFin;
  private Integer codigoFin;
  private String mensajeFin;

  public static final Integer PROCESO_ENCOLADO   = new Integer(0);
  public static final Integer PROCESO_EJECUTANDO = new Integer(1);
  public static final Integer PROCESO_FINALIZADO = new Integer(2);
  public static final Integer PROCESO_ERRONEO    = new Integer(3);
  public static final Integer PROCESO_ABORTADO   = new Integer(4);
   
	public Proceso(String codigo, String thread, String usuario) {
		this(codigo, thread, usuario, null, null, null, null, null, null);	
	}

	public Proceso(String codigo, String thread, String usuario, Integer estado,
	  Date fechaEncolado, Date fechaInicio, Date fechaFin, Integer codigoFin, String mensajeFin) {
	
	  this.codigo =	codigo;
	  this.thread = thread;
	  this.usuario = usuario;
	  this.estado = estado;
	  this.fechaEncolado = fechaEncolado;
	  this.fechaInicio = fechaInicio;
	  this.fechaFin = fechaFin;
	  this.codigoFin = codigoFin;
	  this.mensajeFin = mensajeFin;
	}

  public String getCodigo() { return codigo; }
  public Integer getCodigoFin() { return codigoFin; }
  public Integer getEstado() { return estado; }
  public Date getFechaEncolado() { return fechaEncolado; }
  public Date getFechaFin() {	return fechaFin; }
  public Date getFechaInicio() { return fechaInicio; }
  public String getMensajeFin() { return mensajeFin; }
  public String getThread() { return thread; }
  public String getUsuario() { return usuario; }
  public void setCodigo(String codigo) { this.codigo = codigo; }
  public void setCodigoFin(Integer codigoFin) {	this.codigoFin = codigoFin; }
  public void setEstado(Integer estado) {	this.estado = estado; }
  public void setFechaEncolado(Date fechaEncolado) {	this.fechaEncolado = fechaEncolado; }
  public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
  public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
  public void setMensajeFin(String mensajeFin) { this.mensajeFin = mensajeFin; }
  public void setThread(String thread) { this.thread = thread; }
  public void setUsuario(String usuario) {	this.usuario = usuario; }

  public String toString() {
	  String res = "Process=["+
	    codigo + ", "+ thread+ ", " + usuario + ", " + estado + ", " + fechaEncolado + ", " + fechaInicio + ", " +
	    fechaFin + ", " + codigoFin + ", " + mensajeFin +"]";
	  return res;
  }

  public static boolean estadoEnEjecucion (int estado) {
  	return ((estado == PROCESO_ENCOLADO.intValue()) || (estado==PROCESO_EJECUTANDO.intValue()))? true : false;
  }
  
  public static boolean estadoErroneo (int estado) {
	  return ((estado == PROCESO_ABORTADO.intValue()) || (estado==PROCESO_ERRONEO.intValue()))? true : false;
	}
}
