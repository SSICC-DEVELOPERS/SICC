package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCondicionEvaluacionNrHome extends EJBHome {
    MONCondicionEvaluacionNr create() throws RemoteException, CreateException;
}
