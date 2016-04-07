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

import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;

import java.util.HashMap;

import javax.ejb.EJBObject;

import java.rmi.RemoteException;

import es.indra.sicc.dtos.fac.DTOFACListaConsolidados;

import es.indra.mare.common.exception.MareException;
import java.util.Hashtable;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACVisualizarDoc;


public interface MONProcesosFacturacion extends EJBObject  {
	ArrayList procesar(DTOFACListaConsolidados dtoListaConsolidados) throws RemoteException, MareException;

	Hashtable obtenerValoresTipoSolicitud() throws RemoteException, MareException;

	ArrayList actualizarPosiciones(DTOFACConsolidado dtoConsolidado) throws RemoteException, MareException;

	DTOSalidaBatch ejecutarProcesosFacturacionBatch(DTOBatch dtoin) throws RemoteException, MareException;

	DTOSalidaBatch ejecutarProcesosFacturacion(DTOFACListaConsolidados segmentoConsolidados, Boolean online) throws RemoteException, MareException;

	DTODocumento visualizarDocumentoFacturacion(DTOFACVisualizarDoc dtoEntrada) throws RemoteException;

  DTOFACConsolidado ejecutarProcesosFacturacion(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos) throws MareException, RemoteException;

  void continuarFacturacion(Long oidSolicitud, Boolean estado) throws MareException, RemoteException;

  void revertirActualizarTablas(DTOFACConsolidado consolidado) throws MareException, RemoteException;

    DTOSalidaBatch reSegmentar(DTOBatch dtoin) throws RemoteException, MareException;


    HashMap obtenerPosicionesCabeceras(ArrayList listaOIDs, 
                                       Long oidIdioma) throws MareException, 
                                                              RemoteException;
}
