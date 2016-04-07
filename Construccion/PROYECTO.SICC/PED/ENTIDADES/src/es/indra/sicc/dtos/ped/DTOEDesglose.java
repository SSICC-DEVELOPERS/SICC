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

/**
 * @Autor: Hugo A. Mansi
 * @Fecha: 28/10/2004
 * @DMCO: SICC-DMCO-PED-201-354-N029
 * @Modifico: --
 * @Modificado: --
 * @Descripción:-- 
 * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
 * 
 */


package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOEDesglose  extends DTOSiccPaginacion {
	public int tipoDesglose;
	public Date fechaInicio;
	public Date fechaFin;
	public Long tipoSolicitud;
	public Long marca;
	public Long canal;
	public Long zona;
	public Long grupoProcesos;
	public Long tipoCliente;
	public Long subtipoCliente;
	public Long tipoClasificacion;
	public Long clasificacion;
	public Long acceso;
	public Long estadoSolicitud;
	public Boolean hacerPaginacion;

	public DTOEDesglose() {
	}

	public int getTipoDesglose() {
		return tipoDesglose;
	}

	public void setTipoDesglose(int newTipoDesglose) {
		tipoDesglose = newTipoDesglose;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date newFechaInicio) {
		fechaInicio = newFechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date newFechaFin) {
		fechaFin = newFechaFin;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long newZona) {
		zona = newZona;
	}

	public Long getGrupoProcesos() {
		return grupoProcesos;
	}

	public void setGrupoProcesos(Long newGrupoProcesos) {
		grupoProcesos = newGrupoProcesos;
	}

	public Long getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente) {
		tipoCliente = newTipoCliente;
	}

	public Long getSubtipoCliente() {
		return subtipoCliente;
	}

	public void setSubtipoCliente(Long newSubtipoCliente) {
		subtipoCliente = newSubtipoCliente;
	}

	public Long getTipoClasificacion() {
		return tipoClasificacion;
	}

	public void setTipoClasificacion(Long newTipoClasificacion) {
		tipoClasificacion = newTipoClasificacion;
	}

	public Long getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Long newClasificacion) {
		clasificacion = newClasificacion;
	}

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(Long newEstadoSolicitud) {
		estadoSolicitud = newEstadoSolicitud;
	}

	public Boolean getHacerPaginacion() {
		return hacerPaginacion;
	}

	public void setHacerPaginacion(Boolean newHacerPaginacion) {
		hacerPaginacion = newHacerPaginacion;
	}




	
}