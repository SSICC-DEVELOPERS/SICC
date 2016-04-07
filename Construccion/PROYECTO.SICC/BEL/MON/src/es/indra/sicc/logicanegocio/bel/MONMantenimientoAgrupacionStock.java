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

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOEBuscarAgrupacionStock;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.bel.DTOAgrupacionStock;

public interface MONMantenimientoAgrupacionStock extends EJBObject  {
	/** 
     * Método para buscar agrupaciónes de stock
     * @param dto DTOEBuscarAgrupacionStock con los criterios de busqueda de codigo y descripcion
     * @return DTOSalida con los registros encontrados en la busqueda
     * @exception MareException 
     */
	public DTOSalida buscarAgrupacionStock (DTOEBuscarAgrupacionStock dto) throws MareException,RemoteException;
	
	/** 
     * Método para consultar una agrupacion de Stock
     * @param dto DTOOID con el oid de la Agrupacion de Stock
     * @return DTOAgrupacionStock con los datos de la Agrupacion de Stock (cabecera y detalles)
     * @exception MareException 
     */
	public DTOAgrupacionStock consultarAgrupacionStock (DTOOID dto) throws MareException,RemoteException;

	/** 
     * Método para insertar/modificar una agrupacion de Stock
     * @param dto DTOAgrupacionStock con los datos de la Agrupacion de Stock (cabecera y detalles).
     * @exception MareException 
     */
	public void guardarAgrupacionStock (DTOAgrupacionStock dto) throws MareException,RemoteException;

	/** 
     * Método para eliminar Agrupaciones de Stock
     * @param dto DTOOIDs con los oids de las Agrupaciones de Stock que se desean eliminar.
     * @exception MareException 
     */
	public void eliminarAgrupacionStock (DTOOIDs dto) throws MareException,RemoteException;

	/** 
     * Método para eliminar los detalles de una Agrupacion de Stock
     * @param dto DTOOID con el oid de las Agrupaciones de Stock cuyos detalles se van a eliminar.
     * @exception MareException 
     */
	public void eliminarDetalleAgrupacionStock (DTOOID dto) throws MareException,RemoteException;
}