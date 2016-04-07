package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ped.DTOSecuenciaProcesos;
import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONSecuenciaProcesos extends EJBObject  {
  void elimina(DTOOIDs dto) throws MareException, RemoteException;

  void guarda(DTOSecuenciaProcesos dto) throws MareException, RemoteException;

  DTOSalida consulta(DTOSecuenciaProcesos dto) throws RemoteException, MareException;

  DTOSecuenciaProcesos consultaDetalles(DTOOID dto) throws MareException, RemoteException;

  void verificaGuardar(DTOSecuenciaProcesos dto) throws MareException, RemoteException;

	DTOSalidaBatch reversarBatch(DTOBatch dtoin) throws RemoteException, MareException;

	void reversar(DTOArranqueGP dtoonline, String user) throws RemoteException, MareException;

  MareDTO ejecutar(DTOArranqueGP dtoin) throws RemoteException, MareException;

  DTOSalidaBatch ejecutarBatch(DTOBatch dtoin) throws RemoteException, MareException;

    DTOSalidaBatch reversarSolicitudesServicioBatch(DTOBatch dtoin) throws MareException, RemoteException;


}