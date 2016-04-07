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

public class DTOSiguienteNumeroCupon extends DTOBelcorp {

	private Integer numeroCupon;
	
	public DTOSiguienteNumeroCupon() {
	}

	public Integer getNumeroCupon() {
		return numeroCupon;
	}

	public void setNumeroCupon(Integer newNumeroCupon) {
		numeroCupon = newNumeroCupon;
	}
	
}