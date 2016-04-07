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
import es.indra.sicc.dtos.edu.DTOParticipante;

public class DTORegistrarAsistencia extends DTOBelcorp {

	private Integer operacion;              
	private Long oidCurso;                  
	private DTOParticipante[] participantes;

	public Long getOidCurso() {
		return oidCurso;
	}

	public void setOidCurso(Long newOidCurso) {
		oidCurso = newOidCurso;
	}

	public Integer getOperacion() {
		return operacion;
	}

	public void setOperacion(Integer newOperacion) {
		operacion = newOperacion;
	}

	public DTOParticipante[] getParticipantes() {
		return participantes;
	}

	public void setParticipantes(DTOParticipante[] newParticipantes) {
		participantes = newParticipantes;
	}

}