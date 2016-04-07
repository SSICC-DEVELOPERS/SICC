package es.indra.sicc.logicanegocio.edu;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRegistrarNuevasHome extends EJBHome  {
    MONRegistrarNuevas create() throws RemoteException, CreateException;
}