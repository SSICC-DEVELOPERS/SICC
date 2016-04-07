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

package es.indra.sicc.logicanegocio.edu;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.edu.DTOApta;
import es.indra.sicc.dtos.edu.DTOAsignarAptas;
import es.indra.sicc.dtos.edu.DTOInsertaApta;
import es.indra.sicc.dtos.edu.DTOOIDApta;
import es.indra.sicc.dtos.edu.DTOObtenerAptas;
import es.indra.sicc.dtos.edu.DTOSegundaConvocatoria;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONAptas extends EJBObject  {
	void insertaAptas(DTOInsertaApta dtoe) throws RemoteException, MareException;

	public DTOSalida cargaAsignarAptas(DTOAsignarAptas dtoe) throws MareException, RemoteException;

	public DTOSalida cargaAptasCurso(DTOOIDApta dtoe) throws MareException, RemoteException;

	public DTOOID obtieneAptas(DTOObtenerAptas dtoe) throws MareException, RemoteException;

	public void eliminaAptas(DTOApta dtoe) throws MareException, RemoteException;

	public void segundaConvocatoria(DTOSegundaConvocatoria dtoe) throws MareException, RemoteException;

	
}