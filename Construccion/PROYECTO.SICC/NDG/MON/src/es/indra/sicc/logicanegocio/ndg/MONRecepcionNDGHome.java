package es.indra.sicc.logicanegocio.ndg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRecepcionNDGHome extends EJBHome  {
  MONRecepcionNDG create() throws RemoteException, CreateException;
}