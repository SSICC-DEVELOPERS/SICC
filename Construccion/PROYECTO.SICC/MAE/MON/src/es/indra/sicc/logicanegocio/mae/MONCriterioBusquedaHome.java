package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCriterioBusquedaHome extends EJBHome {
    MONCriterioBusqueda create() throws RemoteException, CreateException;
}
