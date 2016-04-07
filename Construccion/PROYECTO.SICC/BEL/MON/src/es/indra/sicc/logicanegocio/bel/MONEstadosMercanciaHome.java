package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEstadosMercanciaHome extends EJBHome 
{
  MONEstadosMercancia create() throws RemoteException, CreateException;
}