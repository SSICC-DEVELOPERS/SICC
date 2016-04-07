package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoViaHome extends EJBHome {
    MONTipoVia create() throws RemoteException, CreateException;
}
