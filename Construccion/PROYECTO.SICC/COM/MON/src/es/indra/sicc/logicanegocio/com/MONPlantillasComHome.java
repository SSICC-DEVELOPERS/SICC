package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONPlantillasComHome extends EJBHome 
{
  MONPlantillasCom create() throws RemoteException, CreateException;
}