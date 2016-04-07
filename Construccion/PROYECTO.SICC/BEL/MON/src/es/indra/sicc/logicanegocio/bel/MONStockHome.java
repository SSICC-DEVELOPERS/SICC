package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONStockHome extends EJBHome 
{
  MONStock create() throws RemoteException, CreateException;
}