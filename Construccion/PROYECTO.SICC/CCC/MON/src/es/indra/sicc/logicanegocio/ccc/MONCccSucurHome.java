package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCccSucurHome extends EJBHome {
    MONCccSucur create() throws RemoteException, CreateException;
}
