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

package es.indra.sicc.cmn.negocio.batch;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.List;
import es.indra.sicc.cmn.negocio.batch.engine.BatchBusinessDefinition;

public interface MONBatchEJB extends EJBObject 
{
    void registrarProcesoBatch(String codigo, String usuario, String padre) throws MareException, RemoteException;

    Proceso getProcesoBatch(String codigo) throws MareException, RemoteException;

    void esperarHijos(String codProceso) throws  InterruptedException, MareException, RemoteException;

    void setEstadoFinBatch(String codigo, boolean error, Integer codigoFin, String msgFin) throws MareException, RemoteException;

    void setEstadoFinBatch(String codigo) throws MareException, RemoteException;

    void setEstadoEjecucionBatch(String codigo, String servidor, String thread) throws MareException, RemoteException;

    int recuperarCaida(String servidor) throws MareException, RemoteException;

    int recuperarCaida() throws MareException, RemoteException;

    List getProcesosBatch(String usuario) throws MareException, RemoteException;

    List getProcesosBatch() throws MareException, RemoteException;

    void purgarBD() throws MareException, RemoteException;

    void enviaJMS(DTOBatch dtoBatch, BatchBusinessDefinition batchBusinessDefinition) throws Exception, RemoteException;

    void esperarHijosFacturacion(String codProceso) throws  InterruptedException, MareException, RemoteException;
}