package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCondicionPromocionHome extends EJBHome {
    MONCondicionPromocion create() throws RemoteException, CreateException;
}
