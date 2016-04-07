/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.msg.DTOInicioFin;
import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONPatrones extends EJBObject {
    DTOSalida obtenerFormularios(DTOBelcorp DTOE)
        throws RemoteException, MareException;

    DTOPatron guardarPatron(DTOPatron DTOE)
        throws RemoteException, MareException;

    DTOSeccion obtenerSeccion(DTOOID DTOE)
        throws RemoteException, MareException;

    DTOOID guardarSeccion(DTOSeccion DTOE)
        throws RemoteException, MareException;

    void guardarMensaje(Long oidPatronSeccion, DTOMensajeSeccion DTOE)
        throws RemoteException, MareException;

    void modificarSeccion(DTOSeccion DTOE)
        throws RemoteException, MareException;

    void eliminarSeccion(DTOOID DTOE) throws RemoteException, MareException;

    void eliminarMensajesSeccion(DTOOID DTOE)
        throws RemoteException, MareException;

    DTOPatron actualizarPatron(DTOPatron DTOE)
        throws RemoteException, MareException;

    void desplazarSeccionesArriba(DTOInicioFin DTOE)
        throws RemoteException, MareException;

    void desplazarSeccionesAbajo(DTOInicioFin DTOE)
        throws RemoteException, MareException;

    void insertarSeccion(DTOSeccion DTOE) throws RemoteException, MareException;

    DTOSalida obtenerPatronesOrigen(DTOBelcorp DTOE)
        throws RemoteException, MareException;

    DTOSalida obtenerSecciones(DTOOID DTOE)
        throws RemoteException, MareException;

    DTOSalida buscarPatrones(DTOPatron DTOE)
        throws RemoteException, MareException;

    DTOPatron obtenerPatron(DTOOID DTOE) throws RemoteException, MareException;

    void eliminarPatron(DTOOIDs DTOE) throws RemoteException, MareException;

    Boolean esPatronOrigen(Long oidPatron)
        throws RemoteException, MareException;

    DTOPatron obtenerDetallePatron(DTOOID DTOE)
        throws RemoteException, MareException;

    DTOPatron copiarPatron(DTOPatron DTOE)
        throws RemoteException, MareException;

    DTOSalida obtenerMediosEnvioPorPais(DTOBelcorp DTOE)
        throws RemoteException, MareException;

    DTOSalida obtenerMetacaracterEstructura(DTOBelcorp DTOE)
        throws RemoteException, MareException;

	DTOSalida obtenerTodosPatrones(DTOBelcorp DTOE) throws RemoteException, MareException;
}
