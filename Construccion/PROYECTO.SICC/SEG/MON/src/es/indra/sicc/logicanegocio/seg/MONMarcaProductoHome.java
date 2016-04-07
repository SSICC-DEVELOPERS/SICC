package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMarcaProductoHome extends EJBHome {
    MONMarcaProducto create() throws RemoteException, CreateException;
}
