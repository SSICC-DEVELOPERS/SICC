package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParametrosCalculoLcHome extends EJBHome {
    MONParametrosCalculoLc create() throws RemoteException, CreateException;
}
