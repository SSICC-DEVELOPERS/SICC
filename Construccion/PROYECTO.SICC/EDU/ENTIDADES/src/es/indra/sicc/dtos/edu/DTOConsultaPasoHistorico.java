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

import es.indra.sicc.dtos.edu.DTOConsultaCurso;

import java.util.Date;

public class DTOConsultaPasoHistorico extends DTOConsultaCurso {

	private Date fecCurso;

	public Date getFecCurso() {
		return fecCurso;
	}

	public void setFecCurso(Date newFecCurso) {
		fecCurso = newFecCurso;
	}
	
}