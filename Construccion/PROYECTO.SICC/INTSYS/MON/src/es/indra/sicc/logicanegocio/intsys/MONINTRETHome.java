package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTRETHome extends EJBHome  {
  MONINTRET create() throws RemoteException, CreateException;
}