package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONExencionFleteHome extends EJBHome {
    MONExencionFlete create() throws RemoteException, CreateException;
}
