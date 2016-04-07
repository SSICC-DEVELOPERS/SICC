package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONImpuestosGeneralesHome extends EJBHome {
    MONImpuestosGenerales create() throws RemoteException, CreateException;
}
