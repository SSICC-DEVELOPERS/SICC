package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONNivelRiesgoHome extends EJBHome {
    MONNivelRiesgo create() throws RemoteException, CreateException;
}
