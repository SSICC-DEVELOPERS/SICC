package es.indra.sicc.logicanegocio.msg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParametrosMensajeHome extends EJBHome {
    MONParametrosMensaje create() throws RemoteException, CreateException;
}
