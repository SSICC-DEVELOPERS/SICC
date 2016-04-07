package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMarcaHome extends EJBHome {
    MONMarca create() throws RemoteException, CreateException;
}
