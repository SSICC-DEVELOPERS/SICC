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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOCargaInicialConceptos extends DTOBelcorp {

	private Long empresa;
	private Long proceso;

	public DTOCargaInicialConceptos() {
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		this.empresa = newEmpresa;
	}

	public Long getProceso() {
		return this.proceso;
	}

	public void setProceso(Long newProceso) {
		this.proceso = newProceso;
	}
}