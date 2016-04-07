package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRespuestaEncuestaHome extends EJBHome {
    MONRespuestaEncuesta create() throws RemoteException, CreateException;
}
