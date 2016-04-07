package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONInformeFaltantesHome extends EJBHome  {
  MONInformeFaltantes create() throws RemoteException, CreateException;
}