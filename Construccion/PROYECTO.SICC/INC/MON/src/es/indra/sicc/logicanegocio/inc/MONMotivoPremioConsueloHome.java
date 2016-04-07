package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMotivoPremioConsueloHome extends EJBHome {
    MONMotivoPremioConsuelo create() throws RemoteException, CreateException;
}
