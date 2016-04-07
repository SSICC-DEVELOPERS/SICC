package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAEUnidMedidaHome extends EJBHome {
    MAEUnidMedida create() throws RemoteException, CreateException;
}
