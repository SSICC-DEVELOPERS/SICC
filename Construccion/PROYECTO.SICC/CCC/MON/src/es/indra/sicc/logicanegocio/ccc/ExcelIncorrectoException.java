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

import es.indra.sicc.util.ExcepcionParametrizada;

public class ExcelIncorrectoException extends ExcepcionParametrizada {

	private Exception excepcion;


	public ExcelIncorrectoException(String descripcion) {
		super(descripcion);
	}
	public ExcelIncorrectoException(String descripcion, int codigoError) {
		super(descripcion,codigoError);
	}
	public ExcelIncorrectoException(Exception excep) {
		super(excep);
		this.excepcion = excep;
	}

	public ExcelIncorrectoException(Exception excep, int codigoError) {
		super(excep, codigoError);
		this.excepcion = excep;
	}

	public Exception getException() {
		return this.excepcion;
	}
}