/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOInicioFin extends DTOAuditableSICC{
	private Long oidPatron;
	private Integer inicio;
	private Integer fin;

    public DTOInicioFin() {
    }

	public Long getOidPatron() {
		return oidPatron;
	}

	public void setOidPatron(Long newOidPatron) {
		oidPatron = newOidPatron;
	}

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer newInicio) {
		inicio = newInicio;
	}

	public Integer getFin() {
		return fin;
	}

	public void setFin(Integer newFin) {
		fin = newFin;
	}
}
