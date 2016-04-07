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
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.EJBObject;

public interface MONIncentivos
        extends EJBObject {
    DTOEstatusSolicitud concursarSolicitud(DTOSolicitudValidacion solicitud)
            throws RemoteException, MareException;

    DTOEstatusSolicitud revertirPuntajes(DTOSolicitudValidacion solicitudValidacion)
            throws RemoteException, MareException;

    void rechazarSolicitudEnConcursoRanking(Solicitud solicitud, ArrayList concursos)
            throws RemoteException, MareException;

  void actualizarDatosAnulacion(DTOSolicitudValidacion dtoSolicitudValidacion, Long periodoAnulacion) throws RemoteException, MareException;

  DTOEstatusSolicitud anularSolicitud(DTOSolicitudValidacion dtoSolicitud) throws RemoteException, MareException;

  DTOEstatusSolicitud concursarSolicitudRanking(DTOSolicitudValidacion solicitud, Long oidConcurso) throws RemoteException, MareException;

    DTOEstatusSolicitud concursarSolicitudPorConcursos(DTOSolicitudValidacion solicitud, ArrayList arrConcursos) throws RemoteException, MareException;

    DTOEstatusSolicitud calcularPuntajeMontoUnidades(DTOSolicitudValidacion solicitud) throws RemoteException, MareException;

    DTOEstatusSolicitud calcularPuntajeProgramaNuevas(DTOSolicitudValidacion solicitud) throws RemoteException, MareException;

    DTOEstatusSolicitud calcularPuntajeNumeroPedidos(DTOSolicitudValidacion solicitud) throws RemoteException, MareException;

    DTOEstatusSolicitud calcularPuntajeRecomendacion(DTOSolicitudValidacion solicitud) throws RemoteException, MareException;

  void devolverSolicitud(DTOSolicitudValidacion dtoSolicitud) throws MareException, RemoteException;

  void procesarEvaluacionesDevolucion(Solicitud solicitud, ArrayList concursos) throws MareException, RemoteException;

  DTOEstatusSolicitud concursarSolicitudPorConcursosCierre(DTOSolicitudValidacion solicitud, ArrayList arrConcursos) throws MareException, RemoteException;

  void insertaCandidata(Long oidConcurso, Long oidLiente, Long periodo, int numerPeriodosEvaluados, boolean metasSuperadas, boolean requisitosSuperados) throws MareException, RemoteException;
}
