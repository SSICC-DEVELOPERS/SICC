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
 */
package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialLarissa;
import java.util.ArrayList;
import es.indra.sicc.dtos.intsys.DTOINTDocumento;


public interface MONLAR extends EJBObject 
{
	DTOSalidaBatch enviarClasesTipoSolicitud(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch enviarMaestroDestinosClientes(DTOBatch dto) throws RemoteException, MareException;

	DTOSalidaBatch enviarCabeceraDetalleDocumentos(DTOBatch dto) throws MareException, RemoteException;

	void generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaCabeceras) throws RemoteException, MareException;

	void generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaDetalles) throws RemoteException, MareException;

	DTOSalidaBatch enviarDatosImpresionGuias(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch enviarMatrizProductosEstimados(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch enviarMatrizProductosVentaReal(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch enviarMaestroZonas(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch enviarMaestroTerritorios(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch enviarInterfaces(DTOINTCargaInicialLarissa dto) throws MareException, RemoteException;

    DTOColeccion cargaInicial(DTOBelcorp dtoe) throws MareException, RemoteException;

    void generarDocumento(DTOINTCargaInicialLarissa dtoe) throws MareException, RemoteException;

    DTOINTDocumento obtenerCabecera(ArrayList listaDocs) throws MareException, RemoteException;

    DTOSalidaBatch enviarSecuenciaPedidos(DTOBatch dto) throws MareException, RemoteException;

    DTOSalidaBatch enviarDocumentoIdentidadClientes(DTOBatch dto) throws MareException, RemoteException;
}