package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCccTipoTransaccionHome extends EJBHome {
    MONCccTipoTransaccion create() throws RemoteException, CreateException;
}
