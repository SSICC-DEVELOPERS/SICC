package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCajasHome extends EJBHome  {
  MONCajas create() throws RemoteException, CreateException;
}