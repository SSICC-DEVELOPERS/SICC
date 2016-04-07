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
 */


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOProcesoAnterior 
 * Fecha:         5/08/2004
 * Autor:   Hugo Andrés Mansi
*/


package es.indra.sicc.dtos.ped;

public class DTOProcesoAnterior  {
	Long oidProceso;
	Long oidGrupoProceso;

	public DTOProcesoAnterior() {
	}

	public Long getOidProceso() {
		return oidProceso;
	}

	public void setOidProceso(Long newOidProceso) {
		oidProceso = newOidProceso;
	}

	public Long getOidGrupoProceso() {
		return oidGrupoProceso;
	}

	public void setOidGrupoProceso(Long newOidGrupoProceso) {
		oidGrupoProceso = newOidGrupoProceso;
	}
}