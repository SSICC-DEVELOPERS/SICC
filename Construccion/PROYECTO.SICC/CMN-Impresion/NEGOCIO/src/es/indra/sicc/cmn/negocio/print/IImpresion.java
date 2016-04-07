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

package es.indra.sicc.cmn.negocio.print;

import java.rmi.RemoteException;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;

import es.indra.mare.common.exception.MareException;

public interface IImpresion  {
	//public Long openSpool() throws RemoteException,MareException;
    public Long openSpool(Long subacceso) throws RemoteException,MareException;
	public void closeSpool(Long oidSpool) throws RemoteException,MareException;
	public Long addPrintableDocuments(DTODocumento dtoDocumento, Long oidSpool) throws RemoteException,MareException;
	//public void completeSecuence(Long oidSpool, Long numSecuencia) throws RemoteException,MareException;
	//public void refresh() throws RemoteException,MareException;
	// no estan en la inteface 
	//public Boolean getExclusiveAccess(Long idServer) throws RemoteException;
	//public Boolean freeExclusiveAccess(Long idServer) throws RemoteException;
}