package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONBancosHome extends EJBHome {
    MONBancos create() throws RemoteException, CreateException;
}
