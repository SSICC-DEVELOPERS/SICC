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

public class DTOEBuscarFormasPagoDetalle extends DTOSiccPaginacion  {
	private Long oidFormaPagoCabecera;
	private Long oidCanal;            
	private Long oidMarca;            
	private Long oidMedioPago;        
	private Character indicadorDeDias;

	public Character getIndicadorDeDias() {
		return this.indicadorDeDias;
	}

	public void setIndicadorDeDias(Character newIndicadorDeDias) {
		this.indicadorDeDias = newIndicadorDeDias;
	}

	public Long getOidCanal() {
		return this.oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		this.oidCanal = newOidCanal;
	}

	public Long getOidFormaPagoCabecera() {
		return this.oidFormaPagoCabecera;
	}

	public void setOidFormaPagoCabecera(Long newOidFormaPagoCabecera) {
		this.oidFormaPagoCabecera = newOidFormaPagoCabecera;
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
	
}