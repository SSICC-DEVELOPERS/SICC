package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRegularizacionPagosHome extends EJBHome  {
	MONRegularizacionPagos create() throws RemoteException, CreateException;
}