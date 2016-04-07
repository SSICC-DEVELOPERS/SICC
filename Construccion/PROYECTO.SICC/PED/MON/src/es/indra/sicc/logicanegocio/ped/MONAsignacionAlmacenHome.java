package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONAsignacionAlmacenHome extends EJBHome {
    MONAsignacionAlmacen create() throws RemoteException, CreateException;
}
