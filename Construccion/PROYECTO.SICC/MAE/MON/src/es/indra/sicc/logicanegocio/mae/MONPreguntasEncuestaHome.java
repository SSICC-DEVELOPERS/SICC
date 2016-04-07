package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONPreguntasEncuestaHome extends EJBHome {
    MONPreguntasEncuesta create() throws RemoteException, CreateException;
}
