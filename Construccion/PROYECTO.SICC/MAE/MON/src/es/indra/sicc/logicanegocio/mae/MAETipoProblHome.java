package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAETipoProblHome extends EJBHome {
    MAETipoProbl create() throws RemoteException, CreateException;
}
