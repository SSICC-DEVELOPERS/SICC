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
 * Autor : Damasia Maneiro
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOBusquedaFaltantes;
import es.indra.sicc.dtos.inc.DTOPremioSustitutivo;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import java.util.ArrayList;

public interface MONBolsaFaltantes
        extends EJBObject {
    DTOSalida recuperarCodConcursos(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida buscarPremiosFaltantes(DTOBusquedaFaltantes dtoEnt)
            throws RemoteException, MareException;

    void guardarAsignacionFaltantes(DTOPremioSustitutivo dtosus)
            throws RemoteException, MareException;

    DTOSalida obtenerSituacionRegistro(DTOBelcorp dtoe)
            throws RemoteException, MareException;

    DTOSalida obtenerTipoCambio(DTOBelcorp DTOE) throws RemoteException, MareException;

    DTOEstatusSolicitud procesarBolsaFaltantes(DTOSolicitudValidacion dtoSolicitud)
            throws RemoteException, MareException;

    void procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe)
            throws RemoteException, MareException;

    ArrayList obtenerProductosConStock(DTOPremioSustitutivo dtoSus, Faltante faltante) 
            throws RemoteException, MareException;
}
