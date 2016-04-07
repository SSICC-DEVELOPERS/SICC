package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONActivacionConcursos extends EJBObject 
{
    void lanzarActivacionConcursosBatch(MareDTO dtoe) throws RemoteException, MareException;

    void activarConcursosQuartz(MareDTO dtoe) throws RemoteException, MareException;

    DTOSalidaBatch activarConcursosBatch(DTOBatch dtoe) throws RemoteException, MareException;
}