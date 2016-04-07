package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONReterritorializacionHome extends EJBHome 
{
    MONReterritorializacion create() throws RemoteException, CreateException;
}