package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONHIPHome extends EJBHome 
{
  MONHIP create() throws RemoteException, CreateException;
}