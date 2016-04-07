package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTSAPHome extends EJBHome  {
    MONINTSAP create() throws RemoteException, CreateException;
}