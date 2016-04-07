package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONSeguimientoPedidosHome extends EJBHome  {
  MONSeguimientoPedidos create() throws RemoteException, CreateException;
}