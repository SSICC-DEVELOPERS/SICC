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

public class DTOAgrupacionStockDetalle extends DTOBelcorp  {
	private Long oidAgrupacionStockDetalle;
	private Long oidEstadoMercancia;
	private String descripcionEstadoMercancia;
	private Character operacion;

	public String getDescripcionEstadoMercancia() {
		return this.descripcionEstadoMercancia;
	}

	public void setDescripcionEstadoMercancia(String newDescripcionEstadoMercancia) {
		this.descripcionEstadoMercancia = newDescripcionEstadoMercancia;
	}

	public Long getOidAgrupacionStockDetalle() {
		return this.oidAgrupacionStockDetalle;
	}

	public void setOidAgrupacionStockDetalle(Long newOidAgrupacionStockDetalle) {
		this.oidAgrupacionStockDetalle = newOidAgrupacionStockDetalle;
	}

	public Long getOidEstadoMercancia() {
		return this.oidEstadoMercancia;
	}

	public void setOidEstadoMercancia(Long newOidEstadoMercancia) {
		this.oidEstadoMercancia = newOidEstadoMercancia;
	}

	public Character getOperacion() {
		return this.operacion;
	}

	public void setOperacion(Character newOperacion) {
		this.operacion = newOperacion;
	}
}