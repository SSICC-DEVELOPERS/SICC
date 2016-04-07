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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBoolean;

public interface MONMantenimientoCentroDistribucion extends EJBObject {
    void guardarConfiguracionCD(DTOConfiguracionCentroDistribucion dtoE) throws  RemoteException, MareException;

    DTOSalida buscarCentroDistribucion(DTOConfiguracionCentroDistribucion dtoE) throws  RemoteException, MareException;
  
    DTOSalida obtenerNivelesOutSourcing(DTOBelcorp dtoE) throws  RemoteException, MareException;
  
    DTOSalida obtenerCodigoCentrosDistribucion(DTOBelcorp dtoE) throws  RemoteException, MareException;
  
    DTOSalida obtenerDescripcionesCD(DTOBelcorp dtoE) throws  RemoteException, MareException; 
  
    DTOSalida obtenerValoresDefecto(DTOBelcorp dtoe) throws MareException, RemoteException;
  
    DTOOID obtenerCentrosDistribucionXDefecto(DTOBelcorp dtoe) throws MareException, RemoteException;
  
    DTOSalida obtenerAgrupacionAFP(DTOBelcorp dtoe) throws MareException, RemoteException;
  
    DTOSalida obtenerOrdenListaPicado(DTOBelcorp dtoe) throws MareException, RemoteException;

    void eliminarCentroDistribucion(DTOOIDs dtoOids) throws RemoteException, MareException;

    DTOBoolean validarTerritorio(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerCodigoVisualizacionChequeo(DTOBelcorp dtoe) throws MareException, 
                                                                        RemoteException;
}
