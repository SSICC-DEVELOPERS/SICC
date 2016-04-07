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

public class DTOImpuestosGenerales extends DTOBelcorp {

	//se eliminan canal y acceso por la incidencia BELC300009004 
	//cambios reflejados en SICC-DMCO-FAC-201-364-N005-2 

	/*
	private Long canal;  
	private Long acceso;
	*/
	
	private Long subacceso;
	private Long indicadorImpuesto; //Incidencia BELC300008034
	private Long indicadorImpuestoFlete; //Incidencia BELC300008034
	private Boolean indicadorTasaUnica;	//Incidencia BELC300008616
	
	
	public DTOImpuestosGenerales() {
		super();
	}





	public Boolean getIndicadorTasaUnica() {
		return indicadorTasaUnica;
	}

	public void setIndicadorTasaUnica(Boolean newIndicadorTasaUnica) {
		indicadorTasaUnica = newIndicadorTasaUnica;
	}



	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Long getIndicadorImpuesto() {
		return indicadorImpuesto;
	}

	public void setIndicadorImpuesto(Long newIndicadorImpuesto) {
		indicadorImpuesto = newIndicadorImpuesto;
	}

	public Long getIndicadorImpuestoFlete() {
		return indicadorImpuestoFlete;
	}

	public void setIndicadorImpuestoFlete(Long newIndicadorImpuestoFlete) {
		indicadorImpuestoFlete = newIndicadorImpuestoFlete;
	}

	/*
	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}
	*/
}