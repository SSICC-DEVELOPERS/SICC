package es.indra.sicc.logicanegocio.fac;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONImpresoraVirtualHome extends EJBHome {
    MONImpresoraVirtual create() throws RemoteException, CreateException;
}
