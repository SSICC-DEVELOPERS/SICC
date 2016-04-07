package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParametrosEvaluacionNrHome extends EJBHome {
    MONParametrosEvaluacionNr create() throws RemoteException, CreateException;
}
