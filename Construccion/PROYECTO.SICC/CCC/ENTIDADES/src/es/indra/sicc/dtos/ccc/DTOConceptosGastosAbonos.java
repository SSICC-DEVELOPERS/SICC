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

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;


//incidencia BELC300008373
public class DTOConceptosGastosAbonos extends DTOBelcorp {

	protected String codigoCliente;
	protected Long oidCuentaCorriente;
	protected Long oidTipoAbonos;
	protected String glosaContable;
	protected BigDecimal importe;

	public DTOConceptosGastosAbonos() {
		super();
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public Long getOidCuentaCorriente() {
		return oidCuentaCorriente;
	}

	public void setOidCuentaCorriente(Long newOidCuentaCorriente) {
		oidCuentaCorriente = newOidCuentaCorriente;
	}

	public Long getOidTipoAbonos() {
		return oidTipoAbonos;
	}

	public void setOidTipoAbonos(Long newOidTipoAbonos) {
		oidTipoAbonos = newOidTipoAbonos;
	}

	public String getGlosaContable() {
		return glosaContable;
	}

	public void setGlosaContable(String newGlosaContable) {
		glosaContable = newGlosaContable;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal newImporte) {
		importe = newImporte;
	}
}