package es.indra.sicc.logicanegocio.seg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoSEGHome extends EJBHome  {
    MONMantenimientoSEG create() throws RemoteException, CreateException;
}