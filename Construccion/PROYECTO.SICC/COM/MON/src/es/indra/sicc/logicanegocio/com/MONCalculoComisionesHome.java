package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCalculoComisionesHome extends EJBHome 
{
    MONCalculoComisiones create() throws RemoteException, CreateException;
}