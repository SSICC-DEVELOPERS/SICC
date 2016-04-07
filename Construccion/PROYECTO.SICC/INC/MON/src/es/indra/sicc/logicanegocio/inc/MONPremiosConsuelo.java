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

import es.indra.sicc.dtos.inc.DTOConsultarPremiosConsuelo;
import es.indra.sicc.dtos.inc.DTOPremiosConsuelo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import java.util.ArrayList;


import javax.ejb.EJBObject;

public interface MONPremiosConsuelo
        extends EJBObject {
    DTOSalida obtenerEnviarA(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida obtenerMotivosPremiosConsuelo(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerConcursoGanadoras(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerClientesGanadoras(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOSalida guardarPremiosConsuelo(DTOPremiosConsuelo DTOE)
            throws MareException, RemoteException;

    void generarSolicitud(DTOPremiosConsuelo dtoE) throws MareException, RemoteException;

    DTOSalida obtenerArticulosPremioConsuelo() throws MareException, RemoteException;

    DTOSalida obtenerNroConcursoPremiosConsuelo() throws MareException, RemoteException;

    DTOSalida consultarPremiosConsuelo(DTOConsultarPremiosConsuelo dtoE)
            throws RemoteException, MareException;

    void comunicarAlCliente(DTOPremiosConsuelo dtoE) throws MareException, RemoteException;

    void guardarArticulosPremiosConsuelo(ArrayList articulo, Long oidPremioConsuelo)
            throws RemoteException, MareException;

    void guardarClientesPremiosConsuelo(DTOOIDs DTOE, Long oidPremioConsuelo)
            throws RemoteException, MareException;

    void guardarClientesPremioConsueloXnroConcurso(DTOOID DTOE, Long oidPremiosConsuelo)
            throws RemoteException, MareException;

    ArrayList guardarClientesPremioConsueloXFicheroSeleccionado(ArrayList DTOE, Long oidPremioConsuelo, Long oidPais)
            throws RemoteException, MareException;
}

