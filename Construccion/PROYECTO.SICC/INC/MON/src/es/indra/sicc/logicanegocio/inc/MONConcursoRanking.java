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
 *
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTODatosGeneralesConcursoRanking;
import es.indra.sicc.dtos.inc.DTOListaVariablesVentaRanking;
import es.indra.sicc.dtos.inc.DTOParametrosConsultorasRanking;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONConcursoRanking
        extends EJBObject {
    DTOSalida obtenerNivelAgrupamiento(DTOBelcorp DTOE)
            throws RemoteException, MareException;

    DTOSalida obtenerTipoRanking(DTOBelcorp DTOE) throws RemoteException, MareException;

    DTOSalida obtenerTiposProductoRanking(DTOTipoProducto DTOE)
            throws RemoteException, MareException;

    void guardarDatosConcursoRanking(DTOConcurso DTOE)
            throws MareException, RemoteException;

    void guardarDatosGeneralesConcursoRanking(DTOParametrosGeneralesConcurso DTOE)
            throws MareException, RemoteException;

    void guardarVariablesVentaRankingConcurso(DTOListaVariablesVentaRanking DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarParametrosConsultorasRanking(DTOParametrosConsultorasRanking DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosRanking(DTOConcurso DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarPremiosRanking(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    DTOSalida buscarConcursosRanking(DTOBuscarConcursos DTOE)
            throws RemoteException, MareException;

    DTOConcurso obtenerDatosConcursoRanking(DTOOID DTOE)
            throws MareException, RemoteException;

    DTODatosGeneralesConcursoRanking obtenerDatosGeneralesConcursoRanking(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOListaVariablesVentaRanking obtenerVariablesVentaRankingConcurso(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOParametrosConsultorasRanking obtenerParametrosConsultorasRanking(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOParametrosGeneralesPremiacion obtenerPremiosRanking(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerVariablesVentaRanking(DTOBelcorp dtoe)
            throws MareException, RemoteException;

    void borrarAmbitosGeograficos(Long oidConcurso) throws MareException, RemoteException;

    void borrarVariablesVentaRankingConcurso(Long oidConcurso)
            throws MareException, RemoteException;

    void borrarProductosValidos(Long oidConcurso) throws MareException, RemoteException;

    void borrarProductosExcluidos(Long oidConcurso) throws MareException, RemoteException;

    void borrarParametrosGerentes(Long oidConcurso) throws MareException, RemoteException;

    void borrarClasificacionParticipantes(Long oidConcurso)
            throws MareException, RemoteException;

    void borrarParametrosConsultorasRanking(Long oidConcurso)
            throws MareException, RemoteException;

    void borrarPremiosRanking(Long oidConcurso) throws MareException, RemoteException;

    void borrarEstatusVenta(Long oidConcurso) throws MareException, RemoteException;

    DTOSalida obtenerDetalleParticipantes(DTOOID DTOE) throws MareException, RemoteException;
}
