package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONIdiomaHome extends EJBHome {
    MONIdioma create() throws RemoteException, CreateException;
}
