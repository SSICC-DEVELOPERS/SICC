package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.inc.DTOArticuloLoteColeccion;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.entidades.inc.ContadorPremioArticuloLocal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONRemplazoConcurso extends EJBObject {
    DTOSalida obtenerConcursosNumeroNombre(DTOBelcorp dtoe) throws MareException, 
                                                                   RemoteException;

    DTOSalida buscarPremiosConcurso(DTOOID dtoe) throws MareException, 
                                                        RemoteException;

    DTOSalida obtenerReemplazo(DTOOID dteo) throws MareException, 
                                                   RemoteException;

    DTOSalida obtenerCriterioReemplazo(DTOBelcorp dtoe) throws MareException, 
                                                               RemoteException;


    void guardar(DTOArticuloLoteColeccion dtoe) throws MareException, 
                                                       RemoteException;

    Long obtengoCodVentaFicticio(ContadorPremioArticuloLocal contPremioArt) throws MareException, 
                                                                                   RemoteException;

    void LanazarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe) throws MareException, 
                                                                              RemoteException;

    DTOSalidaBatch generarNuevaSolicitudReemplazo(DTOBatch dtoBatch) throws MareException, 
                                                                            RemoteException;

    DTOSalida recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe) throws MareException, 
                                                                           RemoteException;

    void modificar(DTOReemplazoArticuloLote dtoe) throws MareException, 
                                                         RemoteException;

    void eliminar(DTOReemplazoArticuloLote oids) throws MareException, 
                                                        RemoteException;

    DTOSalida obtenerProducto(DTOEBuscarProductos dtoe) throws MareException, 
                                                               RemoteException;

    DTOSalida validarBolsaFaltantes(DTOArticuloLoteColeccion dtoe) throws MareException, 
                                                                          RemoteException;

    DTOSalida validarDatosModificados(DTOArticuloLoteColeccion dtoe) throws MareException, 
            RemoteException;

    void lanzarSolicitudModificados(DTOReemplazoArticuloLote dtoe) throws MareException, 
                                                                          RemoteException;

    DTOSalidaBatch nuevaSolicitudModificado(DTOBatch dtoBatch) throws MareException, 
                                                                      RemoteException;

    DTOSalida obtenerPendientesBolsaFaltantes(DTOOID dteo) throws MareException, 
                                                                  RemoteException;
}
