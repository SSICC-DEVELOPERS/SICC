package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCalculoCubicajeHome extends EJBHome  {
  MONCalculoCubicaje create() throws RemoteException, CreateException;
}