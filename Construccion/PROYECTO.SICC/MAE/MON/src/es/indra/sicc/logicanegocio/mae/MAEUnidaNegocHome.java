package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAEUnidaNegocHome extends EJBHome {
    MAEUnidaNegoc create() throws RemoteException, CreateException;
}
