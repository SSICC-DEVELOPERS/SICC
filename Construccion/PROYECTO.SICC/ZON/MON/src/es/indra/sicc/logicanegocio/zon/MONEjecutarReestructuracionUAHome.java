package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEjecutarReestructuracionUAHome extends EJBHome  {
  MONEjecutarReestructuracionUA create() throws RemoteException, CreateException;
}