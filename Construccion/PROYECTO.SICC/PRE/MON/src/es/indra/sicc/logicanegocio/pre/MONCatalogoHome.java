package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCatalogoHome extends EJBHome {
    MONCatalogo create() throws RemoteException, CreateException;
}
