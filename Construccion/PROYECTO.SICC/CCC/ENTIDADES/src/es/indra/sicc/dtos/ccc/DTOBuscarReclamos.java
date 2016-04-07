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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;


public class DTOBuscarReclamos extends DTOSiccPaginacion {

			private Integer  numeroIdentificacion; 
			private Long  oidBanco;  
			private Long  oidSucursal;     
			private Long  oidCuentaCorriente; 
			private Long  oidClienteReclamante; 
			private Long  oidSituacion;     
   
			private String  anio;    
			private String  mes;  
			private String  codigoClienteReclamante; 
			private String  usuarioSolicitante;    
			private String  usuarioGestorReclamoPrevisto;    
			private String  usuarioGestorReclamoReal;    
 
			private Date fechaDocumento;    

	public String getAnio() {
		return anio;
	}

	public void setAnio(String newAnio) {
		anio = newAnio;
	}

	public String getCodigoClienteReclamante() {
		return codigoClienteReclamante;
	}

	public void setCodigoClienteReclamante(String newCodigoClienteReclamante) {
		codigoClienteReclamante = newCodigoClienteReclamante;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date newFechaDocumento) {
		fechaDocumento = newFechaDocumento;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String newMes) {
		mes = newMes;
	}

	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer newNumeroIdentificacion) {
		numeroIdentificacion = newNumeroIdentificacion;
	}

	public Long getOidBanco() {
		return oidBanco;
	}

	public void setOidBanco(Long newOidBanco) {
		oidBanco = newOidBanco;
	}

	public Long getOidClienteReclamante() {
		return oidClienteReclamante;
	}

	public void setOidClienteReclamante(Long newOidClienteReclamante) {
		oidClienteReclamante = newOidClienteReclamante;
	}

	public Long getOidCuentaCorriente() {
		return oidCuentaCorriente;
	}

	public void setOidCuentaCorriente(Long newOidCuentaCorriente) {
		oidCuentaCorriente = newOidCuentaCorriente;
	}

	public Long getOidSituacion() {
		return oidSituacion;
	}

	public void setOidSituacion(Long newOidSituacion) {
		oidSituacion = newOidSituacion;
	}

	public Long getOidSucursal() {
		return oidSucursal;
	}

	public void setOidSucursal(Long newOidSucursal) {
		oidSucursal = newOidSucursal;
	}

	public String getUsuarioGestorReclamoPrevisto() {
		return usuarioGestorReclamoPrevisto;
	}

	public void setUsuarioGestorReclamoPrevisto(String newUsuarioGestorReclamoPrevisto) {
		usuarioGestorReclamoPrevisto = newUsuarioGestorReclamoPrevisto;
	}

	public String getUsuarioGestorReclamoReal() {
		return usuarioGestorReclamoReal;
	}

	public void setUsuarioGestorReclamoReal(String newUsuarioGestorReclamoReal) {
		usuarioGestorReclamoReal = newUsuarioGestorReclamoReal;
	}

	public String getUsuarioSolicitante() {
		return usuarioSolicitante;
	}

	public void setUsuarioSolicitante(String newUsuarioSolicitante) {
		usuarioSolicitante = newUsuarioSolicitante;
	}
 
			   

	

	
	
}