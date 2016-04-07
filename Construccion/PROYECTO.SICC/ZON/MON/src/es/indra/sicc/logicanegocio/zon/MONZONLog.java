package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import javax.ejb.RemoveException;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.mare.common.exception.MareException;

public interface MONZONLog extends EJBObject  {

    public static final int CANT_CARACTERES_MENSAJE_ERROR = 512;
    
    void reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje) throws RemoteException, MareException;

    void agregarDetalle(Long oid, String typeProc, String mensaje, Object datos) throws RemoteException, MareException;

    DTOManagerFileResult obtenerResultado(Long oId, String typProc) throws RemoteException, MareException;

    Long crearLogProceso(String valTipoProc) throws RemoteException, MareException;
}