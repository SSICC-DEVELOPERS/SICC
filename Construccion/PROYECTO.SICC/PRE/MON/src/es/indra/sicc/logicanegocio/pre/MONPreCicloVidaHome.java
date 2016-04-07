package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONPreCicloVidaHome extends EJBHome {
    MONPreCicloVida create() throws RemoteException, CreateException;
}
