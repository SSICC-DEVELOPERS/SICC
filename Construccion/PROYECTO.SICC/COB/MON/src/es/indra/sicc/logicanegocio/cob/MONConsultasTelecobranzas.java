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

package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOEBuscarConsultorasTelecobranza;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOEBuscarHistoricoCobranza;
import es.indra.sicc.dtos.cob.DTOEBuscarCobranzaExterna;

public interface MONConsultasTelecobranzas extends EJBObject 
{
  DTOSalida buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto) throws MareException, RemoteException;

  DTOSalida buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto) throws MareException, RemoteException;

  DTOSalida buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto) throws MareException, RemoteException;

  DTOSalida obtenerEstadosAsignacion(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto) throws MareException, RemoteException;

  DTOSalida buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto) throws MareException, RemoteException;




}