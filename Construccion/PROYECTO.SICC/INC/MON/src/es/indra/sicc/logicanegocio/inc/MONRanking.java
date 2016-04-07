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
import es.indra.sicc.dtos.inc.DTOParametrosCalculosRanking;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONRanking
        extends EJBObject {
    void evaluarRanking(DTOFACProcesoCierre dtoin) throws MareException, RemoteException;

    void evaluarRanking(DTOFACProcesoCierre dtoin, Long oidConcurso)
            throws MareException, RemoteException;

    void calcularVariablesVentaRanking(DTOParametrosCalculosRanking dtoE)
            throws MareException, RemoteException;

  void preProcesoSolicitudesRanking(Long oidConsultora, Long oidConcurso, Periodo periodoDesde, Periodo periodoHasta) throws RemoteException, MareException;
}
