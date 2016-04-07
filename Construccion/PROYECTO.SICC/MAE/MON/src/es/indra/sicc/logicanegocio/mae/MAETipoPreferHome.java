package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAETipoPreferHome extends EJBHome {
    MAETipoPrefer create() throws RemoteException, CreateException;
}
