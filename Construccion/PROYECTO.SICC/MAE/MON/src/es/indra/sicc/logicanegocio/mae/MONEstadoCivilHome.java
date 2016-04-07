package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEstadoCivilHome extends EJBHome {
    MONEstadoCivil create() throws RemoteException, CreateException;
}
