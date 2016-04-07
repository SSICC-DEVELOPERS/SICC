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
 
package es.indra.sicc.logicanegocio.fac;

import javax.ejb.EJBObject;

import java.rmi.RemoteException;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.fac.DTOFormulariosTipoSolicitud;

import es.indra.mare.common.exception.MareException;

public interface MONParametrizacion extends EJBObject  {
	public DTOSalida cargaFormulariosTipoSolicitud(DTOOID dto) throws RemoteException, MareException;
	public void guardarFormulariosTipoSolicitud(DTOFormulariosTipoSolicitud dto) throws RemoteException, MareException;
	public DTOSalida obtenerTiposDocumentoLegal(DTOBelcorp dto) throws RemoteException, MareException;
	public DTOSalida obtenerFormularios(DTOBelcorp DTOE) throws RemoteException, MareException;

	DTOSalida obtenerTiposCierre(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerNivel(DTOBelcorp dto) throws MareException, RemoteException;
}