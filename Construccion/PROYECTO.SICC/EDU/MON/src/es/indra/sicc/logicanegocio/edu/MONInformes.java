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

package es.indra.sicc.logicanegocio.edu;

import javax.ejb.EJBObject;

import java.rmi.RemoteException;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.edu.DTOConsultaPasoHistorico;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOOIDCurso;
import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.edu.DTORegistrarHistorico;

public interface MONInformes extends EJBObject  {
	DTOSalida cargaPasoHistorico(DTOConsultaPasoHistorico dtoe) throws  MareException, RemoteException;

	void generaPasoHistorico(DTOOID dtoe) throws  MareException, RemoteException;

	DTOSalida cargaRegistrarCurso(DTOConsultaCurso dtoe) throws  MareException, RemoteException;

	DTOSalida cargaParticipantes(DTOOIDCurso dtoe) throws MareException, RemoteException;

	void registraAsistencia(DTORegistrarAsistencia dtoe) throws  MareException, RemoteException;

  void generaPasoHistoricoExtemporaneas( DTORegistrarHistorico dto) throws RemoteException, MareException;

    void generaPasoHistorico(DTORegistrarHistorico dtoe) throws RemoteException, MareException;
}