package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGenerarMovimientosAlmacenHome extends EJBHome  {
  MONGenerarMovimientosAlmacen create() throws RemoteException, CreateException;
}