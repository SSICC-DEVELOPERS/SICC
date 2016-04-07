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
import javax.ejb.EJBLocalObject;
import java.util.List;
import es.indra.sicc.cmn.negocio.batch.engine.BatchBusinessDefinition;

public interface MONBatchEJBLocal extends EJBLocalObject 
{
    void registrarProcesoBatch(String codigo, String usuario, String padre) throws MareException;

    Proceso getProcesoBatch(String codigo) throws MareException;

    void esperarHijos(String codProceso) throws  InterruptedException, MareException;

    void setEstadoFinBatch(String codigo, boolean error, Integer codigoFin, String msgFin) throws MareException;

    void setEstadoFinBatch(String codigo) throws MareException;

    void setEstadoEjecucionBatch(String codigo, String servidor, String thread) throws MareException;

    int recuperarCaida(String servidor) throws MareException;

    int recuperarCaida() throws MareException;

    List getProcesosBatch(String usuario) throws MareException;

    List getProcesosBatch() throws MareException;

    void purgarBD() throws MareException;

    void enviaJMS(DTOBatch dtoBatch, BatchBusinessDefinition batchBusinessDefinition) throws Exception;

    void esperarHijosFacturacion(String codProceso)throws  InterruptedException, MareException;
}