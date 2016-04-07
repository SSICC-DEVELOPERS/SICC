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
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTOArranqueGP;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import java.util.ArrayList;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraSalida;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosSalida;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosEntrada;
import es.indra.sicc.dtos.fac.DTOGenerarConsolidado;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;


public interface MONFacturacion extends EJBObject {
    void arrancarFacturacion(DTOArranqueGP dtoE)
        throws RemoteException, MareException;


	void lanzarProcesosFacturacion(ArrayList listaConsolidados, DTOParametroMonitor parametros, Integer numDecimales) throws RemoteException, MareException;

	DTOFACCalculosCabeceraSalida realizarCalculosCabecera(DTOFACCalculosCabeceraEntrada dtoe) throws RemoteException, MareException;

    DTOFACCalculosImpuestosSalida realizarCalculosImpuestos(DTOFACCalculosImpuestosEntrada dtoe) throws RemoteException, MareException;

	void realizarProyeccionDemandaReal(ArrayList listaSolicitudes) throws RemoteException;

	void realizarDemandaAnticipada(ArrayList listaSolicitudes) throws RemoteException;

	void esperarProcesamiento(String codigoProceso) throws RemoteException, MareException, InterruptedException;

	void arrancarFacturacionReal(DTOArranqueGP dtoE) throws RemoteException, MareException;

	ArrayList crearConsolidados(ArrayList listaCabecerasSolicitud) throws RemoteException, MareException;

	ArrayList filtrarSolicitudesPermitenUnion(ArrayList listaSolicitudes) throws RemoteException, MareException;

	ArrayList generarConsolidados(DTOGenerarConsolidado dtoE) throws RemoteException, MareException;

	ArrayList completarDatosConsolidados() throws RemoteException, MareException;

	MareDTO ejecucionOnline(ArrayList listaSegmentos) throws RemoteException, MareException;

	void ejecucionBatch(ArrayList listaSegmentos, String IDProceso) throws RemoteException, MareException;

	void balancearAreaChequeo() throws RemoteException, MareException;

    void generarNumerosDocumentoInternos(Boolean indicadorOnLine, Long idSpool) throws MareException, RemoteException;

  void generarCodigosListasPicado(Boolean indOnline, Long oidPais) throws MareException, RemoteException;

  void generarNumerosEtiquetas(Boolean indOnline, Long oidPais) throws MareException, RemoteException;

    ArrayList obtenerCabecerasSolicitud(ArrayList listaOIDs) throws MareException, 
                                                                    RemoteException;

    void generarNumerosSecuenciaEtiquetas(Boolean indOnline, 
                                          Long oidPais) throws MareException, 
                                                               RemoteException;

    void asignarNroUnicoCajaListasPicado(Boolean indOnline, 
                                         Long idSpool) throws MareException, 
                                                              RemoteException;

    void actualizarProductosCampana(Boolean indOnline, 
                                    String fechaFacturacion) throws MareException, 
                                                         RemoteException;

    void generarOlas(Boolean indOnline, Long oidPais) throws MareException, 
                                                             RemoteException;

    void procesarGastosAdministrativos(Boolean indOnline, 
                                       Long oidPais) throws MareException, 
                                                            RemoteException;
}
