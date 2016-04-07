package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCORHome extends EJBHome 
{
    MONCOR create() throws RemoteException, CreateException;
}