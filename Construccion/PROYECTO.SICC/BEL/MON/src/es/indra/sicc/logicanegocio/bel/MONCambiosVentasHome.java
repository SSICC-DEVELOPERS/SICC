package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCambiosVentasHome extends EJBHome 
{
  MONCambiosVentas create() throws RemoteException, CreateException;
}