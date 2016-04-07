package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONSecuenciaProcesosHome extends EJBHome {
    MONSecuenciaProcesos create() throws RemoteException, CreateException;
}
