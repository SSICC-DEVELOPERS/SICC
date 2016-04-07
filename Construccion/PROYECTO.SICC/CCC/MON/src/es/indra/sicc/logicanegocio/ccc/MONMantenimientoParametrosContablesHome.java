package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoParametrosContablesHome extends EJBHome  {
  MONMantenimientoParametrosContables create() throws RemoteException, CreateException;
}