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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.math.BigDecimal;

public class DTODatosCargaInicialConceptos extends DTOBelcorp  {

	private RecordSet divisas;
	private String glosaContable;
	private RecordSet cuentasCorrientes;
	private String name;
	private BigDecimal tasaCambioMonedaAlternativa;
	private RecordSet tiposAbono;

	public DTODatosCargaInicialConceptos() {
	}

	public RecordSet getCuentasCorrientes() {
		return this.cuentasCorrientes;
	}

	public void setCuentasCorrientes(RecordSet newCuentasCorrientes) {
		this.cuentasCorrientes = newCuentasCorrientes;
	}

	public RecordSet getDivisas() {
		return this.divisas;
	}

	public void setDivisas(RecordSet newDivisas) {
		this.divisas = newDivisas;
	}

	public String getGlosaContable() {
		return this.glosaContable;
	}

	public void setGlosaContable(String newGlosaContable) {
		this.glosaContable = newGlosaContable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public BigDecimal getTasaCambioMonedaAlternativa() {
		return this.tasaCambioMonedaAlternativa;
	}

	public void setTasaCambioMonedaAlternativa(BigDecimal newTasaCambioMonedaAlternativa) {
		this.tasaCambioMonedaAlternativa = newTasaCambioMonedaAlternativa;
	}

	public RecordSet getTiposAbono() {
		return tiposAbono;
	}

	public void setTiposAbono(RecordSet newTiposAbono) {
		tiposAbono = newTiposAbono;
	}
}