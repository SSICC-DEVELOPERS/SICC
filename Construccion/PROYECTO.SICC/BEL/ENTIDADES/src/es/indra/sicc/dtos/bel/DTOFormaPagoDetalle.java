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
import es.indra.sicc.util.DTOBelcorp;
public class DTOFormaPagoDetalle  extends DTOBelcorp{

	private Long oidFormaPagoDetalle;
	private Long oidMedioPago;
	private String descripcionMedioPago;
	private Integer porcentajePago;
	private Character indicadorDeDias;
	private Integer numeroDeDias;
	private Long oidMarca;
	private String descripcionMarca;
	private Long oidCanal;
	private String descripcionCanal;
	private Long oidActividad;
	private String descripcionActividad;

	public String getDescripcionActividad() {
		return this.descripcionActividad;
	}

	public void setDescripcionActividad(String newDescripcionActividad) {
		this.descripcionActividad = newDescripcionActividad;
	}

	public String getDescripcionCanal() {
		return this.descripcionCanal;
	}

	public void setDescripcionCanal(String newDescripcionCanal) {
		this.descripcionCanal = newDescripcionCanal;
	}

	public String getDescripcionMarca() {
		return this.descripcionMarca;
	}

	public void setDescripcionMarca(String newDescripcionMarca) {
		this.descripcionMarca = newDescripcionMarca;
	}

	public String getDescripcionMedioPago() {
		return this.descripcionMedioPago;
	}

	public void setDescripcionMedioPago(String newDescripcionMedioPago) {
		this.descripcionMedioPago = newDescripcionMedioPago;
	}

	public Character getIndicadorDeDias() {
		return this.indicadorDeDias;
	}

	public void setIndicadorDeDias(Character newIndicadorDeDias) {
		this.indicadorDeDias = newIndicadorDeDias;
	}

	public Integer getNumeroDeDias() {
		return this.numeroDeDias;
	}

	public void setNumeroDeDias(Integer newNumeroDeDias) {
		this.numeroDeDias = newNumeroDeDias;
	}

	public Long getOidActividad() {
		return this.oidActividad;
	}

	public void setOidActividad(Long newOidActividad) {
		this.oidActividad = newOidActividad;
	}

	public Long getOidCanal() {
		return this.oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		this.oidCanal = newOidCanal;
	}

	public Long getOidFormaPagoDetalle() {
		return this.oidFormaPagoDetalle;
	}

	public void setOidFormaPagoDetalle(Long newOidFormaPagoDetalle) {
		this.oidFormaPagoDetalle = newOidFormaPagoDetalle;
	}

	public Long getOidMarca() {
		return this.oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		this.oidMarca = newOidMarca;
	}

	public Long getOidMedioPago() {
		return this.oidMedioPago;
	}

	public void setOidMedioPago(Long newOidMedioPago) {
		this.oidMedioPago = newOidMedioPago;
	}

	public Integer getPorcentajePago() {
		return this.porcentajePago;
	}

	public void setPorcentajePago(Integer newPorcentajePago) {
		this.porcentajePago = newPorcentajePago;
	}



}