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

import java.util.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarCargosAbonos extends DTOSiccPaginacion {

	private Integer numeroIdentificacion;
	private String codigoCliente;
	private Date fechaDocumento;
	private Long proceso;
	private Integer mes;
	private Integer ejercicio;

	public DTOBuscarCargosAbonos() {
	}

	public Integer getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer newNumeroIdentificacion) {
		this.numeroIdentificacion = newNumeroIdentificacion;
	}

	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		this.codigoCliente = newCodigoCliente;
	}

	public Date getFechaDocumento() {
		return this.fechaDocumento;
	}

	public void setFechaDocumento(Date newFechaDocumento) {
		this.fechaDocumento = newFechaDocumento;
	}

	public Long getProceso() {
		return this.proceso;
	}

	public void setProceso(Long newProceso) {
		this.proceso = newProceso;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer newMes) {
		this.mes = newMes;
	}

	public Integer getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Integer newEjercicio) {
		this.ejercicio = newEjercicio;
	}
}