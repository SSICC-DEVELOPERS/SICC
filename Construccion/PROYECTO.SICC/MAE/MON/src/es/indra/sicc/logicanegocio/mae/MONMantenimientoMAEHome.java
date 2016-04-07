package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoMAEHome extends EJBHome  {
    MONMantenimientoMAE create() throws RemoteException, CreateException;
}