package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONINTBatch extends EJBObject  {
    DTOSalidaBatch generarEntradaSAP(DTOBatch dto) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarNegocio(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarSupergenerico(DTOBatch dtoe) throws RemoteException, MareException;

    DTOSalidaBatch recepcionarGenerico(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarProductos(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarDescripcionProductosIdioma(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarStocksDiarios(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarInfoEtiquetasBatch(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarPedProcesPTLBatch(DTOBatch dtoe) throws MareException, RemoteException;
}