package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONActivacionConcursosHome extends EJBHome 
{
  MONActivacionConcursos create() throws RemoteException, CreateException;
}