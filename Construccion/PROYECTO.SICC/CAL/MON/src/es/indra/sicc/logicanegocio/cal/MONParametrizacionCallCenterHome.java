package es.indra.sicc.logicanegocio.cal;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONParametrizacionCallCenterHome extends EJBHome  {
  MONParametrizacionCallCenter create() throws RemoteException, CreateException;
}