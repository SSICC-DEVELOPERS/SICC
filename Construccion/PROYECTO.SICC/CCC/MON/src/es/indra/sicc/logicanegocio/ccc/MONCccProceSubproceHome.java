package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCccProceSubproceHome extends EJBHome {
    MONCccProceSubproce create() throws RemoteException, CreateException;
}
