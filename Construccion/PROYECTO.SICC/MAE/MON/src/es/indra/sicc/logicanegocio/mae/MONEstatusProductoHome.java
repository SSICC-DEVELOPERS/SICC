package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEstatusProductoHome extends EJBHome {
    MONEstatusProducto create() throws RemoteException, CreateException;
}
