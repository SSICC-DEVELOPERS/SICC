package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONSolicitudesBloqueadasHome extends EJBHome  {
	MONSolicitudesBloqueadas create() throws RemoteException, CreateException;
}