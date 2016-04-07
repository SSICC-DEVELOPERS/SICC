package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAdamHome extends EJBHome  {
    MONAdam create() throws RemoteException, CreateException;
}