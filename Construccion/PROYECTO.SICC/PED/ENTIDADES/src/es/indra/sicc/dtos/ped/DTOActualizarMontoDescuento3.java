/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOActualizarMontoDescuento3 extends DTOSiccPaginacion {
	private Long oidCabecera;
	private BigDecimal montoDescuento3;

	public DTOActualizarMontoDescuento3() {
	}

	public Long getOidCabecera() {
		return oidCabecera;
	}

	public void setOidCabecera(Long newOidCabecera) {
		oidCabecera = newOidCabecera;
	}

	public BigDecimal getMontoDescuento3() {
		return montoDescuento3;
	}

	public void setMontoDescuento3(BigDecimal newMontoDescuento3) {
		montoDescuento3 = newMontoDescuento3;
	}
}