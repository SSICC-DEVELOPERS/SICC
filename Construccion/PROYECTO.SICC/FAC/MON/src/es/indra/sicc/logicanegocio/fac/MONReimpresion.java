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

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTODatosDocMensajes;
import es.indra.sicc.dtos.fac.DTODatosCupones;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.fac.DTOOIDsDocumentos;


public interface MONReimpresion extends EJBObject  {
	void reimprimir(DTOOIDsDocumentos dtoOidsDocumentos) throws RemoteException, MareException;

	DTOSalida obtenerSolicitudes(DTODatosDocMensajes dtoEntrada) throws RemoteException, MareException;

	void reimprimirUltimasNoticias(DTOOIDsDocumentos dtoOidsDocumentos) throws RemoteException, MareException;

	void reimprimirCartaConsultoras(DTOOIDsDocumentos dtoOidsDocumentos) throws RemoteException, MareException;

	void reimprimirBoletaDespacho(DTOOIDsDocumentos dtoOidsDocumentos) throws RemoteException, MareException;

	DTOSalida obtenerSolicitudesCupones(DTODatosCupones dtoEntrada) throws RemoteException, MareException;

	void imprimirCuponReemplazo(DTOOIDsDocumentos dtoOidsDocumentos) throws RemoteException, MareException;



}