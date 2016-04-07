package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCierreIncentivosHome
        extends EJBHome {
    MONCierreIncentivos create() throws RemoteException, CreateException;
}
