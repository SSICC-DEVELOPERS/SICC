package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONParametrizacionCOBHome extends EJBHome 
{
  MONParametrizacionCOB create() throws RemoteException, CreateException;
}