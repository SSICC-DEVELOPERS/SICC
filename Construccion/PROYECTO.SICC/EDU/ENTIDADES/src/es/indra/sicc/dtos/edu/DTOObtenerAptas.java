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

package es.indra.sicc.dtos.edu;

import es.indra.sicc.util.DTOBelcorp;

public class DTOObtenerAptas  extends DTOBelcorp {

	private Long oidCurso; 
	private String path;   

	public Long getOidCurso() {
		return oidCurso;
	}

	public void setOidCurso(Long newOidCurso) {
		oidCurso = newOidCurso;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String newPath) {
		path = newPath;
	}

}