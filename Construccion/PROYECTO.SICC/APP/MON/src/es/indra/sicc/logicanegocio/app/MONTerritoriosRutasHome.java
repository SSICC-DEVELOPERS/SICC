package es.indra.sicc.logicanegocio.app;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONTerritoriosRutasHome extends EJBHome {
    MONTerritoriosRutas create() throws RemoteException, CreateException;
}
