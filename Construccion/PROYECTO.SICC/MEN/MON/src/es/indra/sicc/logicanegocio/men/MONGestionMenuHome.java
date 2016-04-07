package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionMenuHome extends EJBHome  {
	MONGestionMenu create() throws RemoteException, CreateException;
}