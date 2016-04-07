package es.indra.sicc.logicanegocio.msg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMedioEnvioHome extends EJBHome {
    MONMedioEnvio create() throws RemoteException, CreateException;
}
