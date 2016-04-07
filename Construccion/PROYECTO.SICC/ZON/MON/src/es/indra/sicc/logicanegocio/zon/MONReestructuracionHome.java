package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONReestructuracionHome extends EJBHome 
{
  MONReestructuracion create() throws RemoteException, CreateException;
}