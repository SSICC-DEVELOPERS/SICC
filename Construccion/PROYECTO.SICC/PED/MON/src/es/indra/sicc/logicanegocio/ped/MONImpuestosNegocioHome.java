package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONImpuestosNegocioHome extends EJBHome {
    MONImpuestosNegocio create() throws RemoteException, CreateException;
}
