package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONSubtipoClienteHome extends EJBHome {
    MONSubtipoCliente create() throws RemoteException, CreateException;
}
