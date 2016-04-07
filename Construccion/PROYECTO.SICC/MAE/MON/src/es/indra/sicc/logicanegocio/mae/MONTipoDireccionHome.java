package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoDireccionHome extends EJBHome 
{
  MONTipoDireccion create() throws RemoteException, CreateException;
}