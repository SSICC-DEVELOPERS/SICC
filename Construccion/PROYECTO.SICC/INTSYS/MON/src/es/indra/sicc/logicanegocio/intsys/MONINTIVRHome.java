package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTIVRHome extends EJBHome  {
    MONINTIVR create() throws RemoteException, CreateException;
}