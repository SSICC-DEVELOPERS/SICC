package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMarcaCorpoMarcaProductoHome extends EJBHome {
    MONMarcaCorpoMarcaProducto create() throws RemoteException, 
                                               CreateException;
}
