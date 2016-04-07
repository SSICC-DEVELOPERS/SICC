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


package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTOFACMatriz extends DTOBelcorp {

	//incidencia: BELC300008481
	private Long catalogo; 
	private Integer pagina;
	
	public DTOFACMatriz() {
		super();
	}

	public Long getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Long newCatalogo) {
		catalogo = newCatalogo;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer newPagina) {
		pagina = newPagina;
	}
}