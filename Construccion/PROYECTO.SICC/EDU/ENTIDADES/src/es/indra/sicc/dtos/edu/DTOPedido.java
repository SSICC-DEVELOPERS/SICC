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

package es.indra.sicc.dtos.edu;

import es.indra.sicc.util.DTOBelcorp;

public class DTOPedido extends DTOBelcorp {

	private Integer operacion;    
	private Long regalo;          
	private Integer momento;      
	private Integer unidades;     
	private Long pais;            
	private Long marca;           
	private Long canal;           
	private Long acceso;          
	private Long oidCliente;      
	private Long oidTipoCliente;
	

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Integer getMomento() {
		return momento;
	}

	public void setMomento(Integer newMomento) {
		momento = newMomento;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Integer getOperacion() {
		return operacion;
	}

	public void setOperacion(Integer newOperacion) {
		operacion = newOperacion;
	}

	public Long getRegalo() {
		return regalo;
	}

	public void setRegalo(Long newRegalo) {
		regalo = newRegalo;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer newUnidades) {
		unidades = newUnidades;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

}