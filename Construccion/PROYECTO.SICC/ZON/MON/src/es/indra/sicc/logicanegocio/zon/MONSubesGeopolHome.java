package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONSubesGeopolHome extends EJBHome 
{
    MONSubesGeopol create() throws RemoteException, CreateException;
}