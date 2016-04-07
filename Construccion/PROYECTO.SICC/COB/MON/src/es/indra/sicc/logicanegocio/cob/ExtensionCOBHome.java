package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface ExtensionCOBHome extends EJBHome 
{
    ExtensionCOB create() throws RemoteException, CreateException;
}