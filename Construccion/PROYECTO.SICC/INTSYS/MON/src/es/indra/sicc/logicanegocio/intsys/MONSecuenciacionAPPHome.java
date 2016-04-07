package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONSecuenciacionAPPHome extends EJBHome  {
    MONSecuenciacionAPP create() throws RemoteException, CreateException;
}