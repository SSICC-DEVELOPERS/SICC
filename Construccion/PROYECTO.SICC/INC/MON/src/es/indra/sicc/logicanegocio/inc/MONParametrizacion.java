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
 * Autor : Julian Rivas, Marta Aurora Montiel, Igor Dedough
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.inc.DTOBusquedaPlantilla;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONParametrizacion
        extends EJBObject {
    DTOSalida consultarTiposCalificacion(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOSalida consultarDirigidoA(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida consultarBasesCalculo(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida consultarTiposVenta(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida consultarTiposConcursoIVR(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    void actualizarPlantilla(DTOPlantilla DTOE) throws MareException, RemoteException;

    DTOSalida buscarPlantillas(DTOBusquedaPlantilla DTOE)
            throws RemoteException, MareException;

    DTOPlantilla obtenerPlantilla(DTOOID DTOE) throws RemoteException, MareException;

    void eliminarPlantilla(DTOOIDs DTOE) throws MareException, RemoteException;

    DTOSalida consultarEstadoConcurso(DTOBelcorp dtoe) throws MareException, 
                                                              RemoteException;
}
