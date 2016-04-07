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
package es.indra.sicc.logicanegocio.app;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.app.DTOSolicCabecSecu;


public interface MONSecuYMarcasChequeo extends EJBObject {
    DTOFACCabeceraSolicitud[] generarSecuenciacionPorMonitor(
        DTOFACCabeceraSolicitud[] dtoE) throws RemoteException, MareException;

    DTOFACCabeceraSolicitud[] generarSecuenciacionPorRutas(
        DTOFACCabeceraSolicitud[] dtoE) throws RemoteException, MareException;

    DTOFACConsolidado[] generarMarcasChequeo(DTOFACConsolidado[] dtoE)
        throws RemoteException, MareException;

    void actualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE) throws RemoteException, MareException;

  void reversarActualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE) throws MareException, RemoteException;

    DTOFACCabeceraSolicitud[] generarSecuenciacionPorCliente(DTOFACCabeceraSolicitud[] dtoE, Character indicadorSecuenciacion) throws RemoteException, MareException;
}
