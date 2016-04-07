/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOBancoSucursal extends DTOBelcorp {

	Long banco;
	Long sucursal;

	public DTOBancoSucursal() {
	}

	public Long getBanco() {
		return banco;
	}

	public void setBanco(Long newBanco) {
		banco = newBanco;
	}

	public Long getSucursal() {
		return sucursal;
	}

	public void setSucursal(Long newSucursal) {
		sucursal = newSucursal;
	}
}