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

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.ccc.DTOAplicarIncobrables;
import es.indra.sicc.dtos.ccc.DTOAprobar;
import es.indra.sicc.dtos.ccc.DTOBuscarLotes;
import es.indra.sicc.dtos.ccc.DTOCargaInicialBuscarLotes;
import es.indra.sicc.dtos.ccc.DTOCargaInicialSeleccion;
import es.indra.sicc.dtos.ccc.DTOConsultarDepuracion;
import es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ccc.DTOBloquearClientes;
import es.indra.sicc.dtos.ccc.DTOOIDPAG;

public interface MONProvisionesDepuraciones extends EJBObject  {
	public DTOCargaInicialSeleccion cargaInicialSeleccion(DTOBelcorp dto) throws MareException, RemoteException;

	public DTOSalida buscarSaldosMorosos(DTOBuscarSaldosMorosos criterios) throws MareException, RemoteException;

	public void aplicarIncobrables(DTOAplicarIncobrables dto) throws MareException, RemoteException;

	DTOSalida buscarClientesBloqueados(DTOBuscarClienteBloqueo dto) throws MareException, RemoteException;

	public void desbloquearClientes(DTOOIDs oids) throws MareException, RemoteException;

	public DTOCargaInicialBuscarLotes cargaInicialBuscarLotes(DTOBelcorp dto) throws MareException, RemoteException;

	public DTOSalida buscarLotes(DTOBuscarLotes dto) throws MareException, RemoteException;

	public DTOConsultarDepuracion obtenerDetalleDepuracion(DTOOIDPAG oid) throws RemoteException, MareException;

	public void eliminarCuotas(DTOOIDs oids) throws RemoteException, MareException;

	public void eliminar(DTOOID dto) throws RemoteException, MareException;

	public void aprobarRechazar(DTOAprobar dto) throws MareException, RemoteException;

	DTOSalida buscarClientesDesbloqueados(DTOBuscarClienteBloqueo dto) throws  MareException, RemoteException;

	void bloquearClientes(DTOBloquearClientes oids) throws RemoteException, MareException;

	DTOConsultarDepuracion obtenerCabeceraDepuracion(DTOOID dto) throws MareException, RemoteException;
}