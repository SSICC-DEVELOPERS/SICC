package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoCCCHome extends EJBHome  {
	MONMantenimientoCCC create() throws RemoteException, CreateException;
}