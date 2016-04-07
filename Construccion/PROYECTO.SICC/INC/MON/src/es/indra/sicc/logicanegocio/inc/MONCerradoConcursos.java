package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.dto.MareDTO;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONCerradoConcursos extends EJBObject  {

    void lanzarCerradoConcursosBatch(MareDTO dtoe) throws RemoteException, MareException;

    DTOSalidaBatch cerrarConcursosBatch(DTOBatch dtoe) throws RemoteException, MareException;

    void cerrarConcursosQuartz(MareDTO dtoe) throws MareException, RemoteException;
}