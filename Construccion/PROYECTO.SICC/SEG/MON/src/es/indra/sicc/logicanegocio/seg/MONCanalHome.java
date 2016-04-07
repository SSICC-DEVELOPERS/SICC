package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCanalHome extends EJBHome {
    MONCanal create() throws RemoteException, CreateException;
}
