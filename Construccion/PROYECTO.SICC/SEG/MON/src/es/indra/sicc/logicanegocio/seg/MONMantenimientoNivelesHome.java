package es.indra.sicc.logicanegocio.seg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoNivelesHome extends EJBHome  {
    MONMantenimientoNiveles create() throws RemoteException, CreateException;
}