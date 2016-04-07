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

public class DTOObtenerCargosAbonos extends DTOBelcorp {

	private Long oid;
	private Boolean modificar;

	public DTOObtenerCargosAbonos() {
	}

	public Boolean getModificar() {
		return this.modificar;
	}

	public void setModificar(Boolean newModificar) {
		this.modificar = newModificar;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long newOid) {
		this.oid = newOid;
	}
}