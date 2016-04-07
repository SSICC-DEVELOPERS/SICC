package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONGenericoHome extends EJBHome {
    MONGenerico create() throws RemoteException, CreateException;
}
