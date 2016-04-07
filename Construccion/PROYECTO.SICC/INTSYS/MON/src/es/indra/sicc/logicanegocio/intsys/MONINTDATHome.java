package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTDATHome extends EJBHome  {
    MONINTDAT create() throws RemoteException, CreateException;
}