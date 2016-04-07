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
//import es.indra.sicc.dtos.edu.DTOParticipante;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.edu.DTOOIDCurso;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.edu.DTOInvita;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.edu.DTOParticipantesValidados;

public interface MONExtemporaneas extends EJBObject  {
	DTOSalida cargaRegistrarExtemporaneas(DTOConsultaCurso dtoe) throws MareException, RemoteException;

	DTOSalida cargaExtemporaneas(DTOOIDCurso dtoe) throws MareException, RemoteException;
    
	void invitaCliente(DTOInvita dtoe) throws MareException , RemoteException;

  DTOParticipantesValidados obtenerParticipantesValidos(DTOOIDs dtoe) throws RemoteException, MareException;
}