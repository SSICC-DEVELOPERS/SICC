package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONValorArgumentoHome extends EJBHome {
    MONValorArgumento create() throws RemoteException, CreateException;
}
