package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCobrarBelcenterHome extends EJBHome 
{
  MONCobrarBelcenter create() throws RemoteException, CreateException;
}