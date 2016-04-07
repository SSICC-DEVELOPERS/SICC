package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONClientesHome extends EJBHome {
    MONClientes create() throws RemoteException, CreateException;
}
