package es.indra.sicc.logicanegocio.intsys;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONOCRHome extends EJBHome  {
  MONOCR create() throws RemoteException, CreateException;
}