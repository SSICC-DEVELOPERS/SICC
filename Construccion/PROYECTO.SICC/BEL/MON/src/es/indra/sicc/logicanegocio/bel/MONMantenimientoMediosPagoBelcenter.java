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

import es.indra.sicc.dtos.bel.DTOEBuscarMediosPagoBelcenter;
import es.indra.sicc.dtos.bel.DTOMediosPagoBelcenter;

import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

public interface MONMantenimientoMediosPagoBelcenter extends EJBObject  {

	public DTOSalida buscarMediosPagoBelcenter (DTOEBuscarMediosPagoBelcenter dto) throws RemoteException, MareException;
	public void eliminarMediosPagoBelcenter (DTOOIDs dto) throws RemoteException, MareException;
	public DTOMediosPagoBelcenter consultarMediosPagoBelcenter (DTOOID dto) throws RemoteException, MareException;
	public void guardarMediosPagoBelcenter (DTOMediosPagoBelcenter dto) throws RemoteException, MareException;
}