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
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.DTOOIDs;

import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.EJBObject;

public interface MONPremiacion
        extends EJBObject {
    DTOEstatusSolicitud premiarPorSolicitud(DTOSolicitudValidacion solicitud)
            throws RemoteException, MareException;

    void tranformarPuntosAPremios(ClientePremiacion clientePremiacion, ArrayList concursos)
            throws RemoteException, MareException;

    void determinarGanadorasRecomendacionConsultora(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente)
            throws RemoteException, MareException;

    DTOEstatusSolicitud revertirPremiacion(DTOSolicitudValidacion solicitudValidacion)
            throws RemoteException, MareException;

    void premiarGerentes(DTOFACProcesoCierre dtoe) throws RemoteException, MareException;

    void premiarRecomendacionGerente(Long oidPais, Long oidPeriodo, Long subacceso)
            throws RemoteException, MareException;

    void premiarPorCierreZona(DTOFACProcesoCierre dtoFac)
            throws RemoteException, MareException;

    DTOOIDs obtenerConcursosRecomendadosOIDs(ArrayList clientesRecomendadosGerencia)
            throws RemoteException, MareException;

    void despacharPremios(ClientePremiacion clientePremiacion)
            throws RemoteException, MareException;

  ArrayList determinarGanadorasRecomendacionConsultoraCalculo(Long pais, Periodo periodo, Long cliente) throws RemoteException, MareException;

    void premiarPorCierrePeriodo(DTOFACProcesoCierre dtoFac) throws RemoteException, MareException;

    DTOEstatusSolicitud determinarGanadorasRecomendacionConsultoraMonitor(DTOSolicitudValidacion solicitud) throws MareException, RemoteException;

    void determinarGanadorasRecomendacionConsultoraCierreZona(DTOFACProcesoCierre dtoin) throws MareException, RemoteException;


}
