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

package es.indra.sicc.cmn.negocio.print;

public class LPRConfiguration extends PrinterSpecificConfiguration {
//a�adido csanchezh extends
	private String ip;
	private String port;
	private String name;

	public LPRConfiguration() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String newIp) {
		ip = newIp;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String newPort) {
		port = newPort;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
}