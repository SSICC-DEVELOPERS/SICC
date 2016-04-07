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

public class DTOCargaInicialCargosAbonos extends DTOBelcorp {

	private Integer numeroIdentificacion;
	private RecordSet procesos;	 
	private RecordSet empresas;
	private RecordSet canales;
	private RecordSet accesos;
	private RecordSet subaccesos;
	private RecordSet subprocesosGestionCheques;
	private BigDecimal tasaCambioMonedaAlternativa;
	public DTOCargaInicialCargosAbonos() {
	}

	public RecordSet getAccesos() {
		return this.accesos;
	}

	public void setAccesos(RecordSet newAccesos) {
		this.accesos = newAccesos;
	}

	public RecordSet getCanales() {
		return this.canales;
	}

	public void setCanales(RecordSet newCanales) {
		this.canales = newCanales;
	}

	public RecordSet getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(RecordSet newEmpresas) {
		this.empresas = newEmpresas;
	}

	public Integer getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer newNumeroIdentificacion) {
		this.numeroIdentificacion = newNumeroIdentificacion;
	}

	public RecordSet getProcesos() {
		return this.procesos;
	}

	public void setProcesos(RecordSet newProcesos) {
		this.procesos = newProcesos;
	}

	public RecordSet getSubaccesos() {
		return this.subaccesos;
	}

	public void setSubaccesos(RecordSet newSubaccesos) {
		this.subaccesos = newSubaccesos;
	}

	public RecordSet getSubprocesosGestionCheques() {
		return this.subprocesosGestionCheques;
	}

	public void setSubprocesosGestionCheques(RecordSet newSubprocesosGestionCheques) {
		this.subprocesosGestionCheques = newSubprocesosGestionCheques;
	}

	public BigDecimal getTasaCambioMonedaAlternativa() {
		return tasaCambioMonedaAlternativa;
	}

	public void setTasaCambioMonedaAlternativa(BigDecimal newTasaCambioMonedaAlternativa) {
		tasaCambioMonedaAlternativa = newTasaCambioMonedaAlternativa;
	}
}