package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONPaisHome extends EJBHome {
    MONPais create() throws RemoteException, CreateException;
}
