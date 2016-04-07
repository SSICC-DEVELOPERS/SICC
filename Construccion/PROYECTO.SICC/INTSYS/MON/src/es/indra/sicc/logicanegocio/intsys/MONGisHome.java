package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGisHome extends EJBHome 
{
  MONGis create() throws RemoteException, CreateException;
}