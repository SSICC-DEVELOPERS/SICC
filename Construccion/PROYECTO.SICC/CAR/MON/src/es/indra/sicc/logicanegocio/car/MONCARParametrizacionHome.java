package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCARParametrizacionHome extends EJBHome  {
	MONCARParametrizacion create() throws RemoteException, CreateException;
}