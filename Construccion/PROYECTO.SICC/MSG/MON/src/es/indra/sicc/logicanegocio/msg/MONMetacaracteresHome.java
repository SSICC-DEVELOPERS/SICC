package es.indra.sicc.logicanegocio.msg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMetacaracteresHome extends EJBHome {
    MONMetacaracteres create() throws RemoteException, CreateException;
}
