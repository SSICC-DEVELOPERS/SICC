package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONModuloHome extends EJBHome {
    MONModulo create() throws RemoteException, CreateException;
}
