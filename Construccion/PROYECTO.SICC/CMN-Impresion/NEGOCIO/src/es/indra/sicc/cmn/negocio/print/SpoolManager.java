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

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface SpoolManager extends EJBObject {
    
    Long addPrintableDocuments(DTODocumento dtoDocumento, Long idSpool) throws RemoteException, MareException;

    void closeSpool(Long idSpool) throws RemoteException, MareException;

    Long openSpool(Long subacceso) throws RemoteException, MareException;

    void nextActivate(Long idSpool) throws RemoteException, MareException;

    Long openSpoolEtiquetas(Long subacceso, Long impresoraEtiquetas) throws RemoteException, MareException;

    void closeSpoolEtiquetas(Long idSpool) throws MareException, RemoteException;

    void closeSpoolColombia(Long idSpool) throws MareException, RemoteException;

}
