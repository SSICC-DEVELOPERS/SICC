package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MAETipoVincuHome extends EJBHome {
    MAETipoVincu create() throws RemoteException, CreateException;
}
