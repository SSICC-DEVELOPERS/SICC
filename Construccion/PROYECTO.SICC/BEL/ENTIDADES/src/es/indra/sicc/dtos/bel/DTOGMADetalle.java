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
import java.math.BigDecimal;
import es.indra.sicc.util.DTOBelcorp;
public class DTOGMADetalle  extends DTOBelcorp{
	private Long oidProducto;
	private Long cantidad;
	private BigDecimal precioVentaNeto;
	private BigDecimal precioContable;

	public Long getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Long newCantidad) {
		this.cantidad = newCantidad;
	}

	public Long getOidProducto() {
		return this.oidProducto;
	}

	public void setOidProducto(Long newOidProducto) {
		this.oidProducto = newOidProducto;
	}

	public BigDecimal getPrecioContable() {
		return this.precioContable;
	}

	public void setPrecioContable(BigDecimal newPrecioContable) {
		this.precioContable = newPrecioContable;
	}

	public BigDecimal getPrecioVentaNeto() {
		return this.precioVentaNeto;
	}

	public void setPrecioVentaNeto(BigDecimal newPrecioVentaNeto) {
		this.precioVentaNeto = newPrecioVentaNeto;
	}
}