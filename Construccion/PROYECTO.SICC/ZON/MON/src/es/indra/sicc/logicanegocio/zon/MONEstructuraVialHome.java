package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEstructuraVialHome extends EJBHome  {
    MONEstructuraVial create() throws RemoteException, CreateException;
}