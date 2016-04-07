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

public class DTOAptaAsignada extends DTOBelcorp {

	private Long curso;              
	private Long cliente;            
	private Long subtipo;            
	private Boolean apta;            
	private Boolean dataMart;        
	private Integer numConvocatoria; 

	public Boolean getApta() {
		return apta;
	}

	public void setApta(Boolean newApta) {
		apta = newApta;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long newCliente) {
		cliente = newCliente;
	}

	public Long getCurso() {
		return curso;
	}

	public void setCurso(Long newCurso) {
		curso = newCurso;
	}

	public Boolean getDataMart() {
		return dataMart;
	}

	public void setDataMart(Boolean newDataMart) {
		dataMart = newDataMart;
	}

	public Integer getNumConvocatoria() {
		return numConvocatoria;
	}

	public void setNumConvocatoria(Integer newNumConvocatoria) {
		numConvocatoria = newNumConvocatoria;
	}

	public Long getSubtipo() {
		return subtipo;
	}

	public void setSubtipo(Long newSubtipo) {
		subtipo = newSubtipo;
	}

}