package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAEMagniHome extends EJBHome {
    MAEMagni create() throws RemoteException, CreateException;
}
