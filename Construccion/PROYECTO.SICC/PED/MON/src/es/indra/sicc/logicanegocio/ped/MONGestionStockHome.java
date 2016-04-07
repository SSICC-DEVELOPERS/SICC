package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionStockHome extends EJBHome 
{
  MONGestionStock create() throws RemoteException, CreateException;
}