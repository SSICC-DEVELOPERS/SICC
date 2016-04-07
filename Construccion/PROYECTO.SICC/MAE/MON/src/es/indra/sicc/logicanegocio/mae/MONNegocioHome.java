package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONNegocioHome extends EJBHome {
    MONNegocio create() throws RemoteException, CreateException;
}
