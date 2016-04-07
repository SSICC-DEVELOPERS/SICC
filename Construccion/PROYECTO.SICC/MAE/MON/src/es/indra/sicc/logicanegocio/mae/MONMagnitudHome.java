package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMagnitudHome extends EJBHome {
    MONMagnitud create() throws RemoteException, CreateException;
}
