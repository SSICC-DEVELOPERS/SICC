package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCCCCuentaCorrientHome extends EJBHome {
    MONCCCCuentaCorrient create() throws RemoteException, CreateException;
}
