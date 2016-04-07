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

public class DTOBuscarSeguimientoPedidos extends DTOSiccPaginacion {
	private Long canal;
	private Long acceso;
	private Long subacceso;
	private Long numeroConsolidado;
	private Long hito;
	private Long tipoDocumento;

	public DTOBuscarSeguimientoPedidos() {
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Long getNumeroConsolidado() {
		return numeroConsolidado;
	}

	public void setNumeroConsolidado(Long newNumeroConsolidado) {
		numeroConsolidado = newNumeroConsolidado;
	}

	public Long getHito() {
		return hito;
	}

	public void setHito(Long newHito) {
		hito = newHito;
	}

	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long newTipoDocumento) {
		tipoDocumento = newTipoDocumento;
	}
}