package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCalcularComisionesHome extends EJBHome 
{
  MONCalcularComisiones create() throws RemoteException, CreateException;
}