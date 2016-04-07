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
import java.util.ArrayList;

public class DTOAlerta extends DTOBelcorp {

	private Boolean indAlerta;
	private String codigoMensajeAlerta;
	// private String mensajeAlerta; // eliminado por incidencia BELC300010464
	private ArrayList parametrosAlerta; // añadido por incidencia BELC300010464
	
	public DTOAlerta() {
		super();
	}

	public String getCodigoMensajeAlerta() {
		return this.codigoMensajeAlerta;
	}

	public void setCodigoMensajeAlerta(String newCodigoMensajeAlerta) {
		this.codigoMensajeAlerta = newCodigoMensajeAlerta;
	}

	public Boolean getIndAlerta() {
		return this.indAlerta;
	}

	public void setIndAlerta(Boolean newIndAlerta) {
		this.indAlerta = newIndAlerta;
	}

	public ArrayList getParametrosAlerta() {
		return this.parametrosAlerta;
	}

	public void setParametrosAlerta(ArrayList newParametrosAlerta) {
		this.parametrosAlerta = newParametrosAlerta;
	}



}