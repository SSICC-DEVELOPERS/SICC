package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAsignacionProductosHome extends EJBHome {
    MONAsignacionProductos create() throws RemoteException, CreateException;
}