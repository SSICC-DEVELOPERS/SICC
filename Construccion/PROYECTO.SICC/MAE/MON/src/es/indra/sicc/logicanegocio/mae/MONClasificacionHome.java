package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONClasificacionHome extends EJBHome {
    MONClasificacion create() throws RemoteException, CreateException;
}
