package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONLevantamientoChequeoHome extends EJBHome  {
    MONLevantamientoChequeo create() throws RemoteException, CreateException;
}