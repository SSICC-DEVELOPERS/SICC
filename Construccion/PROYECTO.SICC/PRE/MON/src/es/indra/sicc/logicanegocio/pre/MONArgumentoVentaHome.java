package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONArgumentoVentaHome extends EJBHome {
    MONArgumentoVenta create() throws RemoteException, CreateException;
}
