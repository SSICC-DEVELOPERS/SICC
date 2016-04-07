package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONConfiguracionGuiaProductoHome extends EJBHome {
    MONConfiguracionGuiaProducto create() throws RemoteException, 
                                                 CreateException;
}
