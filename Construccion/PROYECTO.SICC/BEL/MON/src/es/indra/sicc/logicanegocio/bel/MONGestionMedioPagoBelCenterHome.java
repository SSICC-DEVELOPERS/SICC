package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionMedioPagoBelCenterHome extends EJBHome  {
	MONGestionMedioPagoBelCenter create() throws RemoteException, CreateException;
}