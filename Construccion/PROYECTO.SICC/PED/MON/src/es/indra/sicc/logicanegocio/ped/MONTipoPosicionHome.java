package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoPosicionHome extends EJBHome {
    MONTipoPosicion create() throws RemoteException, CreateException;
}
