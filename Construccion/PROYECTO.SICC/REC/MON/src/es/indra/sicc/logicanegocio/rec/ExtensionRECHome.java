package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface ExtensionRECHome extends EJBHome 
{
    ExtensionREC create() throws RemoteException, CreateException;
}