package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.intsys.DTOINTEnviarMovimientos;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;


public interface MONINTSAP extends EJBObject  {
    void generarEntradaSAP(DTOOID dto) throws MareException, RemoteException;

    void recepcionarNegocio(DTOOID pais) throws MareException, RemoteException;

    void recepcionarSupergenerico(DTOOID pais) throws MareException, RemoteException;

    void recepcionarGenerico(DTOOID pais) throws MareException, RemoteException;

    //void recepcionarProductos(DTOOID pais) throws MareException, RemoteException;

    void recepcionarDescripcionProductosIdioma(DTOOID pais) throws MareException, RemoteException;

    //void recepcionarStocksDiarios(DTOOID pais) throws MareException, RemoteException;

    DTOSalidaBatch enviarMovimientosAlmacenDiarios(DTOBatch dtoBatch) throws RemoteException, MareException;

    void recepcionarProductos(DTOOID dto) throws MareException, RemoteException;

    void recepcionarStocksDiarios(DTOOID dto) throws MareException, RemoteException;

  void enviarMovimientosAlmacenDiariosBatch(DTOINTEnviarMovimientos dtoe) throws MareException, RemoteException;
}