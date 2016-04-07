/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarMediosPagoBelcenter extends DTOSiccPaginacion  {

	private Long oidCanal;
	private Long oidAcceso;
	private Long oidSubacceso;
	private String codigoMedioPago;
	private String descripcion;
	private Long oidTipoMedioPago;

	public String getCodigoMedioPago() {
		return this.codigoMedioPago;
	}

	public void setCodigoMedioPago(String newCodigoMedioPago) {
		this.codigoMedioPago = newCodigoMedioPago;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		this.descripcion = newDescripcion;
	}

	public Long getOidAcceso() {
		return this.oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		this.oidAcceso = newOidAcceso;
	}

	public Long getOidCanal() {
		return this.oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		this.oidCanal = newOidCanal;
	}

	public Long getOidSubacceso() {
		return this.oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		this.oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoMedioPago() {
		return this.oidTipoMedioPago;
	}

	public void setOidTipoMedioPago(Long newOidTipoMedioPago) {
		this.oidTipoMedioPago = newOidTipoMedioPago;
	}
	

}