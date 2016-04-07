package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONPreasignarProductosHome extends EJBHome  {
  MONPreasignarProductos create() throws RemoteException, CreateException;
}