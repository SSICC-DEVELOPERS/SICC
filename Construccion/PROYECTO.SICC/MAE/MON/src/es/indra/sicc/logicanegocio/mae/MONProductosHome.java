package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONProductosHome extends EJBHome 
{
    MONProductos create() throws RemoteException, CreateException;
}