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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOTerritorio extends DTOSiccPaginacion{

	private Long oidRuta;
	private String territorioDesde;
	private String territorioHasta;
	
	public DTOTerritorio() {
		super();
	}

	public Long getOidRuta() {
		return oidRuta;
	}

	public void setOidRuta(Long newOidRuta) {
		oidRuta = newOidRuta;
	}

	public String getTerritorioDesde() {
		return territorioDesde;
	}

	public void setTerritorioDesde(String newTerritorioDesde) {
		territorioDesde = newTerritorioDesde;
	}

	public String getTerritorioHasta() {
		return territorioHasta;
	}

	public void setTerritorioHasta(String newTerritorioHasta) {
		territorioHasta = newTerritorioHasta;
	}
}