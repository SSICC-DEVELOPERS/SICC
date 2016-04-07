package es.indra.sicc.logicanegocio.cal;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONBuzonHome extends EJBHome {
  MONBuzon create() throws RemoteException, CreateException;
}