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

//import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarCuentasCorrientes extends DTOSiccPaginacion  {

	private String cliente; //BELC300005212
	private Integer identificadorCuota;
	private Integer numeroOrdenCuota;
	private Long proceso;
	private Long empresa;
	private String subproceso;
	private Integer subacceso;
	private Integer ejercicioCuota;
	
	private Long canal; //BELC300007620
	private Long acceso; //BELC300007620

	public DTOBuscarCuentasCorrientes() {
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String newCliente) {
		this.cliente = newCliente;
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		this.empresa = newEmpresa;
	}

	public Integer getIdentificadorCuota() {
		return this.identificadorCuota;
	}

	public void setIdentificadorCuota(Integer newIdentificadorCuota) {
		this.identificadorCuota = newIdentificadorCuota;
	}

	public Integer getNumeroOrdenCuota() {
		return this.numeroOrdenCuota;
	}

	public void setNumeroOrdenCuota(Integer newNumeroOrdenCuota) {
		this.numeroOrdenCuota = newNumeroOrdenCuota;
	}

	public Long getProceso() {
		return this.proceso;
	}

	public void setProceso(Long newProceso) {
		this.proceso = newProceso;
	}

	public String getSubproceso(){
		return this.subproceso;
	}
	
	public void setSubproceso(String newSubproceso){
		this.subproceso = newSubproceso;
	}

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

	public Integer getEjercicioCuota() {
		return ejercicioCuota;
	}

	public void setEjercicioCuota(Integer newEjercicioCuota) {
		ejercicioCuota = newEjercicioCuota;
	}

	public Integer getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Integer newSubacceso) {
		subacceso = newSubacceso;
	}
}