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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface IServicioBEL  {

	public Long recuperarStockEstadosAgrupados(Long pais, Long almacen, Long producto, String codigoAgrupacion) throws MareException;
	public DTOSalida obtenerMediosPagoCombo(DTOBelcorp dto) throws MareException;
	public DTOSalida obtenerTiposMedioPago(DTOBelcorp dto) throws MareException;
	public DTOSalida obtenerFormasPagoCabecera(DTOBelcorp dto) throws MareException;
	public DTOSalida obtenerEstadosMercancia(DTOBelcorp dto) throws MareException;
	public DTOSalida obtenerAlmacenes(DTOBelcorp dto) throws MareException;
	public DTOSalida obtenerOperaciones() throws MareException;
	public DTOSalida consultarFPagoDetalNumPosi(DTOOID dtoe) throws MareException;
  public DTOSalida buscarStockProducto (DTOBuscarStockProducto dto) throws MareException; //incidencia 12317
	
}