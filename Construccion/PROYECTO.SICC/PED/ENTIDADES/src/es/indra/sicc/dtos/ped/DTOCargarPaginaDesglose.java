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
import es.indra.sicc.util.DTOBelcorp;

public class DTOCargarPaginaDesglose extends DTOBelcorp  {
	public Long oidMarca;
	public String descripcionMarca;
	public Long oidCanal;
	public String descripcionCanal;
	public Long oidZona;
	public String descripcionZona;
	public Long oidGrupoProcesos;
	public String descripcionGrupoProcesos;
	public Long oidTipoSolicitud;
	public String descripcionTipoSolicitud;
	public Long totalSolcitudes;

	public DTOCargarPaginaDesglose() {
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String newDescripcionMarca) {
		descripcionMarca = newDescripcionMarca;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public String getDescripcionCanal() {
		return descripcionCanal;
	}

	public void setDescripcionCanal(String newDescripcionCanal) {
		descripcionCanal = newDescripcionCanal;
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}

	public String getDescripcionZona() {
		return descripcionZona;
	}

	public void setDescripcionZona(String newDescripcionZona) {
		descripcionZona = newDescripcionZona;
	}

	public Long getOidGrupoProcesos() {
		return oidGrupoProcesos;
	}

	public void setOidGrupoProcesos(Long newOidGrupoProcesos) {
		oidGrupoProcesos = newOidGrupoProcesos;
	}

	public String getDescripcionGrupoProcesos() {
		return descripcionGrupoProcesos;
	}

	public void setDescripcionGrupoProcesos(String newDescripcionGrupoProcesos) {
		descripcionGrupoProcesos = newDescripcionGrupoProcesos;
	}

	public Long getOidTipoSolicitud() {
		return oidTipoSolicitud;
	}

	public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
		oidTipoSolicitud = newOidTipoSolicitud;
	}

	public String getDescripcionTipoSolicitud() {
		return descripcionTipoSolicitud;
	}

	public void setDescripcionTipoSolicitud(String newDescripcionTipoSolicitud) {
		descripcionTipoSolicitud = newDescripcionTipoSolicitud;
	}

	public Long getTotalSolcitudes() {
		return totalSolcitudes;
	}

	public void setTotalSolcitudes(Long newTotalSolcitudes) {
		totalSolcitudes = newTotalSolcitudes;
	}
}