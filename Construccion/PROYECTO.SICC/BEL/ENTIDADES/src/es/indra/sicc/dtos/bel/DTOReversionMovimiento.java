/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.bel;
import es.indra.sicc.util.DTOBelcorp;

public class DTOReversionMovimiento extends DTOBelcorp {
	Long pais;
	Long subacceso;
	String numDocumento;
	Integer numLinea;
	Long operacion;

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String newNumDocumento) {
		numDocumento = newNumDocumento;
	}

	public Integer getNumLinea() {
		return numLinea;
	}

	public void setNumLinea(Integer newNumLinea) {
		numLinea = newNumLinea;
	}

	public Long getOperacion() {
		return operacion;
	}

	public void setOperacion(Long newOperacion) {
		operacion = newOperacion;
	}
}