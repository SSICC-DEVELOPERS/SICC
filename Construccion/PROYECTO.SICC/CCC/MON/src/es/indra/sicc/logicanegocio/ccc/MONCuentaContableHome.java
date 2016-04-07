package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCuentaContableHome extends EJBHome {
    MONCuentaContable create() throws RemoteException, CreateException;
}
