package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalcularMetasHome
        extends EJBHome {
    MONCalcularMetas create() throws RemoteException, CreateException;
}
