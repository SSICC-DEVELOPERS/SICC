package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAETipoSolucHome extends EJBHome {
    MAETipoSoluc create() throws RemoteException, CreateException;
}
