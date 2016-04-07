package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONAccesoHome extends EJBHome {
    MONAcceso create() throws RemoteException, CreateException;
}
