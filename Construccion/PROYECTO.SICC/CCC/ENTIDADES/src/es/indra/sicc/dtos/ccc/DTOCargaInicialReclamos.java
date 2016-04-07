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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCargaInicialReclamos extends DTOBelcorp {

	RecordSet canales;
	RecordSet accesos;
	RecordSet subaccesos;
	RecordSet bancos;
	RecordSet sucursales;
	RecordSet cuentas;
	RecordSet mediosPago;
	RecordSet periodos;
	RecordSet motivosRechazoDesbloqueo;
	RecordSet situaciones;
	RecordSet empresas;
	RecordSet usuarios;//BELC300008185
	
	Integer numero; // BELC300004710

	public DTOCargaInicialReclamos() {
	}

	public RecordSet getAccesos() {
		return accesos;
	}

	public void setAccesos(RecordSet newAccesos) {
		accesos = newAccesos;
	}

	public RecordSet getBancos() {
		return bancos;
	}

	public void setBancos(RecordSet newBancos) {
		bancos = newBancos;
	}

	public RecordSet getCanales() {
		return canales;
	}

	public void setCanales(RecordSet newCanales) {
		canales = newCanales;
	}

	public RecordSet getCuentas() {
		return cuentas;
	}

	public void setCuentas(RecordSet newCuentas) {
		cuentas = newCuentas;
	}

	public RecordSet getEmpresas() {
		return empresas;
	}

	public void setEmpresas(RecordSet newEmpresas) {
		empresas = newEmpresas;
	}

	public RecordSet getMediosPago() {
		return mediosPago;
	}

	public void setMediosPago(RecordSet newMediosPago) {
		mediosPago = newMediosPago;
	}

	public RecordSet getMotivosRechazoDesbloqueo() {
		return motivosRechazoDesbloqueo;
	}

	public void setMotivosRechazoDesbloqueo(RecordSet newMotivosRechazoDesbloqueo) {
		motivosRechazoDesbloqueo = newMotivosRechazoDesbloqueo;
	}

	public RecordSet getPeriodos() {
		return periodos;
	}

	public void setPeriodos(RecordSet newPeriodos) {
		periodos = newPeriodos;
	}

	public RecordSet getSituaciones() {
		return situaciones;
	}

	public void setSituaciones(RecordSet newSituaciones) {
		situaciones = newSituaciones;
	}

	public RecordSet getSubaccesos() {
		return subaccesos;
	}

	public void setSubaccesos(RecordSet newSubaccesos) {
		subaccesos = newSubaccesos;
	}

	public RecordSet getSucursales() {
		return sucursales;
	}

	public void setSucursales(RecordSet newSucursales) {
		sucursales = newSucursales;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer newNumero) {
		numero = newNumero;
	}

	public RecordSet getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(RecordSet newUsuarios) {
		usuarios = newUsuarios;
	}
}