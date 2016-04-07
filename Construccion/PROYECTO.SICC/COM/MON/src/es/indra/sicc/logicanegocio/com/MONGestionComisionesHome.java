package es.indra.sicc.logicanegocio.com;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionComisionesHome extends EJBHome {
  MONGestionComisiones create() throws RemoteException, CreateException;
}