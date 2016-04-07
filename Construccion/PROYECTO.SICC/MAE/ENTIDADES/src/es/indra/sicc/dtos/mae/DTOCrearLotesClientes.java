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

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           11/2/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Rodrigo Falcó
 */

public class DTOCrearLotesClientes  extends DTOAuditableSICC   {

	private Integer numClientes;

	public Integer getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(Integer newNumClientes) {
		numClientes = newNumClientes;
	}

}