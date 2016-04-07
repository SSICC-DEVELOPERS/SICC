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

package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;

public class DTOAlmOrigDest extends DTOBelcorp {
	private Long oidAlmacenOrigen;
	private Long oidAlmacenDestino;

	public Long getOidAlmacenDestino() {
		return oidAlmacenDestino;
	}

	public void setOidAlmacenDestino(Long newOidAlmacenDestino) {
		oidAlmacenDestino = newOidAlmacenDestino;
	}

	public Long getOidAlmacenOrigen() {
		return oidAlmacenOrigen;
	}

	public void setOidAlmacenOrigen(Long newOidAlmacenOrigen) {
		oidAlmacenOrigen = newOidAlmacenOrigen;
	}
}