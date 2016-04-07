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
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

import es.indra.sicc.dtos.intsys.DTOParametrosContablesFAC;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.intsys.DTOINT;
import java.util.ArrayList;

public interface MONINTSAPFI extends EJBObject  {
   DTOSalidaBatch generarApuntesContablesCC(DTOBatch dtoe) throws RemoteException, MareException;

   Long getMoneda() throws RemoteException;

   void setMoneda(Long moneda) throws RemoteException;

   String getNumeroLote() throws RemoteException;

   void setNumeroLote(String numeroLote) throws RemoteException;

    DTOSalidaBatch generarApuntesContablesFAC(DTOBatch dtoE) throws MareException, RemoteException;

    DTOSalidaBatch enviarApuntesContables(DTOINT dtoE) throws RemoteException, MareException;

  DTOSalida obtenerImportesContablesFAC() throws MareException, RemoteException;

  DTOSalida buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE) throws MareException, RemoteException;

  void actualizarParametrosContablesFAC(DTOParametrosContablesFAC dtoe) throws MareException, RemoteException;

  void eliminarParametrosContablesFAC(DTOOIDs oids) throws MareException, RemoteException;

  void actualizarImporteRedondeo() throws MareException, RemoteException;

    DTOSalidaBatch recepcionarImpuestosProdNacionales(DTOBatch dtoe) throws MareException, 
                                                                            RemoteException;
}
