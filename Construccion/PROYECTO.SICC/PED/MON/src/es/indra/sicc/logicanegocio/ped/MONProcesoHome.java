package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONProcesoHome extends EJBHome {
    MONProceso create() throws RemoteException, CreateException;
}
