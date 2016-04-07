package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMAEEstatusClienteHome extends EJBHome {
    MONMAEEstatusCliente create() throws RemoteException, CreateException;
}
