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
 * Autor: Hugo A. Mansi
 * Fecha de creación: 3 de agosto de 2004
 * Paquete N0002 PED
 * 
 */

package es.indra.sicc.logicanegocio.ped;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOListaProcesos;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOProceso;

public interface MONGrupoProcesoSolicitud extends EJBObject  {
	DTOEstatusSolicitud procesarSolicitudReverso(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws RemoteException, MareException;

  DTOEstatusSolicitud procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws RemoteException, MareException;

  DTOEstatusSolicitud procesarSolicitudOnLine(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws RemoteException, MareException;

  DTOEstatusSolicitud procesarSolicitudReversoOnline(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws RemoteException, MareException;


}