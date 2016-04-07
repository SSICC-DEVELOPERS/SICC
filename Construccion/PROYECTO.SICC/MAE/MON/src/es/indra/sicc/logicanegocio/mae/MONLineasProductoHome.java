package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONLineasProductoHome extends EJBHome {
    MONLineasProducto create() throws RemoteException, CreateException;
}
