/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Subm�dulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           11/2/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Rodrigo Falc�
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