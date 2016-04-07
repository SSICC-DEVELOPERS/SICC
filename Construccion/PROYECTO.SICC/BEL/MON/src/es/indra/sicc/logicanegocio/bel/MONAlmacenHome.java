package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAlmacenHome extends EJBHome  {
  MONAlmacen create() throws RemoteException, CreateException;
}
