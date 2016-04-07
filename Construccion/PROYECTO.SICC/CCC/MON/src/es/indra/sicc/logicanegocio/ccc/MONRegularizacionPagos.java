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

package es.indra.sicc.logicanegocio.ccc;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.mare.common.exception.MareException;
//import es.indra.sicc.dtos.ccc.DTOBancoSucursal;
import es.indra.sicc.dtos.ccc.DTOBuscarReclamos;
//import es.indra.sicc.dtos.ccc.DTOCargaInicialReclamos;
import es.indra.sicc.dtos.ccc.DTOReclamo;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTONumeroReclamo;

import es.indra.sicc.util.DTOBelcorp;

public interface MONRegularizacionPagos extends EJBObject  {
	public void guardarReclamo(DTOReclamo dto) throws MareException, RemoteException;


	public DTOSalida recargaSucursales(DTOOID dto) throws MareException, RemoteException;

	public DTOSalida recargaCuentas(DTOOID dto) throws MareException, RemoteException;

	public DTOSalida buscarReclamos(DTOBuscarReclamos criterios) throws MareException, RemoteException;

	public void eliminar(DTOOIDs oids) throws MareException, RemoteException;

	public DTOReclamo obtenerReclamo(DTOOID oid) throws MareException, RemoteException;

	public void procesar(DTOOIDs oids) throws MareException, RemoteException;

	DTOSalida obtenerSituacionesReclamo(DTOBelcorp dto) throws RemoteException, MareException;

	DTONumeroReclamo obtenerSiguienteNumero(DTOBelcorp dto) throws RemoteException, MareException;

}