/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.edu;

import es.indra.sicc.util.DTOBelcorp;

import java.util.Date;

public class DTOParticipante extends DTOBelcorp {

	private Long oidParticipante;
	private Long oidCliente;     
	private Long oidTipoCliente; 
	private Date fecAsistencia;  
  private Integer numeroRegistro;
  private Integer asistenciaCurso;
  private Integer numConvoc;

	public Date getFecAsistencia() {
		return fecAsistencia;
	}

	public void setFecAsistencia(Date newFecAsistencia) {
		fecAsistencia = newFecAsistencia;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidParticipante() {
		return oidParticipante;
	}

	public void setOidParticipante(Long newOidParticipante) {
		oidParticipante = newOidParticipante;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

  
  /**
   * @auth Walter Sebastian Ancho, 5/12/2005, (GCC-EDU-009)
   * @return 
   */
  public Integer getNumeroRegistro() {
    return numeroRegistro;
  }

  /**
   * @auth Walter Sebastian Ancho, 5/12/2005, (GCC-EDU-009)
   * @return void
   */
  public void setNumeroRegistro(Integer numeroRegistro) {
    this.numeroRegistro = numeroRegistro;
  }

  /**
   * @author: ssantana, 7/12/2005, SICC-GCC-EDU-009
   * @return Integer
   */
  public Integer getAsistenciaCurso() {
    return asistenciaCurso;
  }

  /**
   * @author: ssantana, 7/12/2005, SICC-GCC-EDU-009
   * @param Integer asistenciaCurso
   */
  public void setAsistenciaCurso(Integer asistenciaCurso) {
    this.asistenciaCurso = asistenciaCurso;
  }

  /**
   * @author: ssantana, 7/12/2005, SICC-GCC-EDU-009
   * @return Integer
   */
  public Integer getNumConvoc() {
    return numConvoc;
  }

  /**
   * @author: ssantana, 7/12/2005, SICC-GCC-EDU-009
   * @param Integer numConvoc
   */
  public void setNumConvoc(Integer numConvoc) {
    this.numConvoc = numConvoc;
  }

}