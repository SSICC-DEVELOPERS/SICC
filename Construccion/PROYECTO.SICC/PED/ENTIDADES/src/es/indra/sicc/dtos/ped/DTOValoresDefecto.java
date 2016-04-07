/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas .
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * Componente : DTOTipoSolicitudProceso.java
 * Autor: Hugo Mansi      
 * Creado: 12 de julio de 2004
 * Modificado:
 */
 
package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOValoresDefecto extends DTOSiccPaginacion {
	private Long modulo;
	private String formulario;
	private Long tipoSolicitud;
	private String[] campo;
	private String[] valor;
	private Boolean[] obligatorio;
	private Boolean[] editable;
	
	public DTOValoresDefecto() {
	}

	public Long getModulo() {
		return modulo;
	}

	public void setModulo(Long newModulo) {
		modulo = newModulo;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String newFormulario) {
		formulario = newFormulario;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public String[] getCampo() {
		return campo;
	}

	public void setCampo(String[] campo) {
		this.campo = campo;
	}

	public String[] getValor() {
		return valor;
	}

	public void setValor(String[] valor) {
		this.valor = valor;
	}	

	public Boolean[] getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(Boolean[] obligatorio) {
		this.obligatorio = obligatorio;
	}	

	public Boolean[] getEditable() {
		return editable;
	}

	public void setEditable(Boolean[] editable) {
		this.editable = editable;
	}	
}