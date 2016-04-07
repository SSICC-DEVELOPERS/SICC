package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCatalogoOrdenHome extends EJBHome {
    MONCatalogoOrden create() throws RemoteException, CreateException;
}
