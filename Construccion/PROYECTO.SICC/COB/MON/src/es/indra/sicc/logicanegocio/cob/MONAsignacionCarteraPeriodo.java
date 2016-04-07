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
import javax.ejb.EJBObject;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOConsultarAsignacionCartera;
import es.indra.sicc.dtos.cob.DTOEBuscarEtapas;
import es.indra.sicc.dtos.cob.DTOActualizacionCartera;
import es.indra.sicc.dtos.cob.DTOConsultarResumenAsignacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.cob.DTOAsignacionCobranza;
import java.util.ArrayList;

public interface MONAsignacionCarteraPeriodo extends EJBObject 
{
  void asignarCarteraPeriodo(DTOColeccion dto) throws MareException, RemoteException;

  DTOSalida detalleCobranza(DTOOIDPaginado dto) throws RemoteException, MareException;

  DTOSalida consultarAsignacionCartera(DTOConsultarAsignacionCartera dto) throws MareException, RemoteException;

  DTOSalida listadoEtapa(DTOEBuscarEtapas dto) throws MareException, RemoteException;

  void actualizarEstadoCartera(DTOActualizacionCartera dto) throws MareException, RemoteException;

  DTOSalida consultarResumenAsignacion(DTOConsultarResumenAsignacion dto) throws MareException, RemoteException;

  void asignarCuota(DTOAsignacionCobranza dtoAsignacion, ArrayList oidsCronoUsuEtapa, Long balanceo) throws MareException, RemoteException;
}