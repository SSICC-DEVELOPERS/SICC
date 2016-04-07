/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOMatrizCodigoRecuperacion extends DTOAuditableSICC 
{
	RecordSet periodos;
	RecordSet productoRecuperado;

	public RecordSet getPeriodos() {
		return periodos;
	}

	public void setPeriodos(RecordSet newPeriodos) {
		periodos = newPeriodos;
	}

	public RecordSet getProductoRecuperado() {
		return productoRecuperado;
	}

	public void setProductoRecuperado(RecordSet newProductoRecuperado) {
		productoRecuperado = newProductoRecuperado;
	}
  
}