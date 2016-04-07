/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.sql.Timestamp;

public class DTOEstadisticasDigitacion extends DTOAuditableSICC{
	private Long oidEstadisticas;
	private Timestamp inicioSesion;
	private String usuario;
	private Long numeroOC;
	private Long errorOC;
	private Long numeroCV;
	private Long errorCV;
	private Long procesoPedidos;
	private Long tipoSolicitud;
	private Long periodo;
	private Timestamp finSesion;

	public DTOEstadisticasDigitacion() {
	}

	public Long getOidEstadisticas() {
		return oidEstadisticas;
	}

	public void setOidEstadisticas(Long newOidEstadisticas) {
		oidEstadisticas = newOidEstadisticas;
	}

	public Timestamp getInicioSesion() {
		return inicioSesion;
	}

	public void setInicioSesion(Timestamp newInicioSesion) {
		inicioSesion = newInicioSesion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String newUsuario) {
		usuario = newUsuario;
	}

	public Long getNumeroOC() {
		return numeroOC;
	}

	public void setNumeroOC(Long newNumeroOC) {
		numeroOC = newNumeroOC;
	}

	public Long getErrorOC() {
		return errorOC;
	}

	public void setErrorOC(Long newErrorOC) {
		errorOC = newErrorOC;
	}

	public Long getNumeroCV() {
		return numeroCV;
	}

	public void setNumeroCV(Long newNumeroCV) {
		numeroCV = newNumeroCV;
	}

	public Long getErrorCV() {
		return errorCV;
	}

	public void setErrorCV(Long newErrorCV) {
		errorCV = newErrorCV;
	}

	public Long getProcesoPedidos() {
		return procesoPedidos;
	}

	public void setProcesoPedidos(Long newProcesoPedidos) {
		procesoPedidos = newProcesoPedidos;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public Timestamp getFinSesion() {
		return finSesion;
	}

	public void setFinSesion(Timestamp newFinSesion) {
		finSesion = newFinSesion;
	}
}