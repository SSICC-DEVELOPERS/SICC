package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEstructuraGeoPoliticaHome extends EJBHome 
{
  MONEstructuraGeoPolitica create() throws RemoteException, CreateException;
}