package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONZONLogHome extends EJBHome  {
    MONZONLog create() throws RemoteException, CreateException;
}