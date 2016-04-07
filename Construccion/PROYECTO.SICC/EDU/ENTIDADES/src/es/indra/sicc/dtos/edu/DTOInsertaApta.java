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

public class DTOInsertaApta extends DTOBelcorp {

	private Long oidAsigna;    
	private Long oidCurso;     
	private Integer indOrigen; 

	public Integer getIndOrigen() {
		return indOrigen;
	}

	public void setIndOrigen(Integer newIndOrigen) {
		indOrigen = newIndOrigen;
	}

	public Long getOidAsigna() {
		return oidAsigna;
	}

	public void setOidAsigna(Long newOidAsigna) {
		oidAsigna = newOidAsigna;
	}

	public Long getOidCurso() {
		return oidCurso;
	}

	public void setOidCurso(Long newOidCurso) {
		oidCurso = newOidCurso;
	}

}