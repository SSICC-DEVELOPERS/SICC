package es.indra.sicc.logicanegocio.prueba;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRegistroOnlineHome extends EJBHome  {
  MONRegistroOnline create() throws RemoteException, CreateException;
}