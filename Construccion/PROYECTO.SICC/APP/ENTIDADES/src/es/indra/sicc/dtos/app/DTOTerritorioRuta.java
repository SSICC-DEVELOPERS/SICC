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

package es.indra.sicc.dtos.app;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTerritorioRuta extends DTOBelcorp {

	Long oid;              
	Long oidRuta;          
	Long oidTerritorio;    
	Long numeroSecuencia;  

	public DTOTerritorioRuta() {
		super();
	}

	public Long getNumeroSecuencia() {
		return numeroSecuencia;
	}

	public void setNumeroSecuencia(Long newNumeroSecuencia) {
		numeroSecuencia = newNumeroSecuencia;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getOidTerritorio() {
		return oidTerritorio;
	}

	public void setOidTerritorio(Long newOidTerritorio) {
		oidTerritorio = newOidTerritorio;
	}

	public Long getOidRuta() {
		return oidRuta;
	}

	public void setOidRuta(Long newOidRuta) {
		oidRuta = newOidRuta;
	}
}