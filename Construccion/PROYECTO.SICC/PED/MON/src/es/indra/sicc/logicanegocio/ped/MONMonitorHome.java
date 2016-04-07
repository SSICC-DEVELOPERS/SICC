package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONMonitorHome extends EJBHome {
    MONMonitor create() throws RemoteException, CreateException;
}
