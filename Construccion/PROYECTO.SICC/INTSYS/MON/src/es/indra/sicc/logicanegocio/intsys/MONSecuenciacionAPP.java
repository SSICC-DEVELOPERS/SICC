package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONSecuenciacionAPP extends EJBObject  {
    DTOSalidaBatch recepcionarSecuenciacionAPPBatch(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException, RemoteException;

}