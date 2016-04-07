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

public class DTOBuscarCuotasPendientes extends DTOSiccPaginacion {

	private String codigoCliente;
	private Long cuota;
	private String empresa;
	

	public DTOBuscarCuotasPendientes() {
	}

	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		this.codigoCliente = newCodigoCliente;
	}

	public Long getCuota() {
		return this.cuota;
	}

	public void setCuota(Long newCuota) {
		this.cuota = newCuota;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String newEmpresa) {
		this.empresa = newEmpresa;
	}
}