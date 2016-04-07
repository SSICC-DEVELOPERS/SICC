package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEjecutarReterritorializacionHome extends EJBHome  {
  MONEjecutarReterritorializacion create() throws RemoteException, CreateException;
}