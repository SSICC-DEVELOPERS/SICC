/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.dtos.intsys.DTOECMRecibir;
import es.indra.sicc.dtos.intsys.DTOINT;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import java.util.Date;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;

public interface MONECM extends EJBObject 
{
	DTOSalidaBatch cargarVentasPED(DTOBatch dtoBatch) throws RemoteException, MareException;

	DTOSalidaBatch cargarVentasINC(DTOBatch dtoBatch) throws RemoteException, MareException;

	DTOSalidaBatch cargarVentasINT(DTOBatch dtoBatch) throws RemoteException, MareException;

	DTOSalidaBatch recibirVentasAsociadas(DTOINT dto) throws MareException, RemoteException;

	DTOSalidaBatch recibirClientesBatch(DTOINT dto) throws MareException, RemoteException;

	DTOSalidaBatch recibirClientes(DTOBatch dto) throws RemoteException, MareException;

	DTOSalidaBatch enviarClientesConsultoraBatch(DTOINT dto) throws RemoteException, MareException;

	DTOSalidaBatch enviarClientesConsultora(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch recibirVentasSistemaBatch(DTOINT dto) throws RemoteException, MareException;

	DTOSalidaBatch recibirVentasSistema(DTOBatch dto) throws MareException, RemoteException;

	DTOSalidaBatch tratarRegistroClientes(IRegistroSicc registro, InterfazInfo info) throws RemoteException, MareException;

	void generarClientesConsultoras(Date fechaActuacion, String codInterfaz, DTOECMRecibir dtoe) throws MareException, RemoteException;

    void realizarCreate(DTOINT dto, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi) throws MareException, RemoteException;
}