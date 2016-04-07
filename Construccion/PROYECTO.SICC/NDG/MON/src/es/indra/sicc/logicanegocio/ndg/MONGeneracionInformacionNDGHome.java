package es.indra.sicc.logicanegocio.ndg;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGeneracionInformacionNDGHome extends EJBHome  {
  MONGeneracionInformacionNDG create() throws RemoteException, CreateException;
}