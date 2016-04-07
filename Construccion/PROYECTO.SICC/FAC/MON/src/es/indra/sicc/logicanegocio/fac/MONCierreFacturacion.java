package es.indra.sicc.logicanegocio.fac;

import es.indra.sicc.dtos.fac.DTOCargaInicialCierre;
import es.indra.sicc.util.DTOSalida;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.fac.DTODatosProgramaCierre;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.util.DTOBelcorp;

public interface MONCierreFacturacion extends EJBObject  {
    void tramitarCierre(DTOFACCierreFacturacion dtoe) throws RemoteException, MareException;

    DTOSalidaBatch tramitarCierreBatch(DTOBatch dtoin) throws RemoteException, MareException;

    DTOSalidaBatch ejecutaProcesoCierre(DTOBatch dtoe) throws RemoteException, MareException;

  DTOSalidaBatch cerrarZonaSegmento(DTOBatch dto) throws RemoteException, MareException;

    DTOSalida obtenerRegiones(DTODatosProgramaCierre dto) throws MareException, 
                                                                 RemoteException;

    DTOSalida obtenerZonas(DTODatosProgramaCierre dto) throws MareException, 
                                                              RemoteException;

    DTOSalida obtenerDatosPeriodo(DTODatosProgramaCierre dto) throws MareException, 
                                                                     RemoteException;

    void actualizarProgramaCierre(DTOFACCierreFacturacion dtoe, Long oidRegion, 
                                  int totalProcesos) throws MareException, 
                                                            RemoteException;

    DTOCargaInicialCierre cargaInicialCierre(DTOBelcorp dto) throws MareException, 
                                                                    RemoteException;
}
