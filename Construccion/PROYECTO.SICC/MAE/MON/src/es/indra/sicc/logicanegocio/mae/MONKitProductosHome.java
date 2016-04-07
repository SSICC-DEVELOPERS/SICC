package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONKitProductosHome extends EJBHome  {
    MONKitProductos create() throws RemoteException, CreateException;
}