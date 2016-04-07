package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONNivelEstudioHome extends EJBHome {
    MONNivelEstudio create() throws RemoteException, CreateException;
}
