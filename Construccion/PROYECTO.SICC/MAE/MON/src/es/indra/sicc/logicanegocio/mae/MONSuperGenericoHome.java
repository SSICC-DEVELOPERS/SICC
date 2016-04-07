package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONSuperGenericoHome extends EJBHome {
    MONSuperGenerico create() throws RemoteException, CreateException;
}
