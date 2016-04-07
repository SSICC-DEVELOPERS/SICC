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

package es.indra.sicc.cmn.negocio.print;

public class FileConfiguration extends PrinterSpecificConfiguration {//dendria que heredar de  PrinterSpecificConfiguration

	private String path;
	private String filename;

	public FileConfiguration() {
	}

	public String getPath() {
		return path;
	}

	public void setPath(String newPath) {
		path = newPath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String newFilename) {
		filename = newFilename;
	}
	
}