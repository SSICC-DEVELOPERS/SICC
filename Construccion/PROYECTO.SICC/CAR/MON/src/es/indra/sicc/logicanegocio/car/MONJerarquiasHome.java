package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONJerarquiasHome extends EJBHome {
    MONJerarquias create() throws RemoteException, CreateException;
}
