package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface ExtensionINTHome extends EJBHome 
{
    ExtensionINT create() throws RemoteException, CreateException;
}