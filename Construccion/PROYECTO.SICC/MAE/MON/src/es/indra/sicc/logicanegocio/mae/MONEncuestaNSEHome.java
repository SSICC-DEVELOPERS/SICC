package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEncuestaNSEHome extends EJBHome {
    MONEncuestaNSE create() throws RemoteException, CreateException;
}
