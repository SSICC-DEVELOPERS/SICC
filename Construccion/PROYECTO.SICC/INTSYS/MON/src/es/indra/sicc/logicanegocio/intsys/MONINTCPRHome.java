package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTCPRHome extends EJBHome  {
  MONINTCPR create() throws RemoteException, CreateException;
}