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
 
package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;

public class LoteContabilizadoException extends MareException {
	private Exception excepcion;
	
	public LoteContabilizadoException() {
		super();
	}

	public LoteContabilizadoException(String descripcion) {
		super(descripcion);
	}	

	public LoteContabilizadoException(Exception excepcion) {
		super(excepcion);
		this.excepcion = excepcion;
	}

	public LoteContabilizadoException(Exception excepcion, int codigoError) {
		super(excepcion, codigoError);
		this.excepcion = excepcion;
	}
	
	//Añadido por CDOS
	public LoteContabilizadoException(java.lang.String param1, java.lang.Throwable param2, int param3) {
       		 super(param1, param2, param3);
   	}
	
	public Exception getException() {
		return this.excepcion;
	}
}