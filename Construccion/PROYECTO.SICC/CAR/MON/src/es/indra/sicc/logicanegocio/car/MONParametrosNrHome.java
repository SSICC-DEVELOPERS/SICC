package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParametrosNrHome extends EJBHome {
    MONParametrosNr create() throws RemoteException, CreateException;
}
