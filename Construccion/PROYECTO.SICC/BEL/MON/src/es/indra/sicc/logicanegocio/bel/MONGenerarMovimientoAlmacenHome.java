package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGenerarMovimientoAlmacenHome extends EJBHome  {
	MONGenerarMovimientoAlmacen create() throws RemoteException, CreateException;
}