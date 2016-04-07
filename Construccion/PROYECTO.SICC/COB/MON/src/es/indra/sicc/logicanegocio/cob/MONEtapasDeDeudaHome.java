package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEtapasDeDeudaHome extends EJBHome {
    MONEtapasDeDeuda create() throws RemoteException, CreateException;
}
