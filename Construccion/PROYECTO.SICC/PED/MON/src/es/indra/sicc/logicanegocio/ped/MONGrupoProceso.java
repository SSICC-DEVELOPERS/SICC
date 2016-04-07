package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOProcesoAnterior;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.ped.DTOListaProcesos;

public interface MONGrupoProceso extends EJBObject  {
  MareDTO ejecutar(DTOEjecucionProcesos dtoin) throws RemoteException, MareException;

  DTOSalidaBatch ejecutarBatch(DTOBatch dtoin) throws RemoteException, MareException;

  void reversar(DTOEjecucionProcesos dtoin) throws RemoteException, MareException;

	DTOSalidaBatch reversarBatch(DTOBatch dtoin) throws RemoteException, MareException;

  DTOSalidaBatch reSegmentar(DTOBatch dtoin) throws RemoteException, MareException;

  MareDTO procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dto, DTOListaProcesos listaProcesos) throws RemoteException, MareException;

    void actualizarProcesoSolicitud(Long oidSolicitud, Long oidGrupoProceso, Long oidProceso, Long estatus) throws RemoteException, MareException;

    DTOSalidaBatch ejecutarCacheEntidades(DTOBatch dtoin) throws MareException,
                                                                 RemoteException;
}
