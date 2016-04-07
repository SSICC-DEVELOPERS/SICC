package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONContactosHome extends EJBHome 
{
    MONContactos create() throws RemoteException, CreateException;
}