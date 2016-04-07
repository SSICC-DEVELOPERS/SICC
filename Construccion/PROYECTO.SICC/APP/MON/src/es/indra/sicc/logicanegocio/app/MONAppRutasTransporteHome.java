package es.indra.sicc.logicanegocio.app;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONAppRutasTransporteHome extends EJBHome {
    MONAppRutasTransporte create() throws RemoteException, CreateException;
}
