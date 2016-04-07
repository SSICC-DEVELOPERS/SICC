package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAETipoProblTipoSolucHome extends EJBHome {
    MAETipoProblTipoSoluc create() throws RemoteException, CreateException;
}
