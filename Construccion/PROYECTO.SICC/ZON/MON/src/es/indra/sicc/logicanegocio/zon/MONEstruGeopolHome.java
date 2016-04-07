package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEstruGeopolHome extends EJBHome 
{
    MONEstruGeopol create() throws RemoteException, CreateException;
}