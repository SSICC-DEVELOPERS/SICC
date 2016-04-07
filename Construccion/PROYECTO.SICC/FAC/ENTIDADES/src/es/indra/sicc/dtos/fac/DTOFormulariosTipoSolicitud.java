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
 
package es.indra.sicc.dtos.fac;

import java.util.Map;
import es.indra.sicc.util.DTOBelcorp;

public class DTOFormulariosTipoSolicitud extends DTOBelcorp  {
	private Long tipoSolicitud;
	private Map formularios;

	public DTOFormulariosTipoSolicitud() {
		super();
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Map getFormularios() {
		return formularios;
	}

	public void setFormularios(Map newFormularios) {
		formularios = newFormularios;
	}
}