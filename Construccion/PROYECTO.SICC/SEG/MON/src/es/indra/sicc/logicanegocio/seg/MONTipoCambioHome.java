package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoCambioHome extends EJBHome {
    MONTipoCambio create() throws RemoteException, CreateException;
}
