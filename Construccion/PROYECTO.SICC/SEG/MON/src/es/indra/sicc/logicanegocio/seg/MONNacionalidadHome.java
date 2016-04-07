package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONNacionalidadHome extends EJBHome {
    MONNacionalidad create() throws RemoteException, CreateException;
}
