package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONBalanceoLineaHome extends EJBHome {
    MONBalanceoLinea create() throws RemoteException, CreateException;
}