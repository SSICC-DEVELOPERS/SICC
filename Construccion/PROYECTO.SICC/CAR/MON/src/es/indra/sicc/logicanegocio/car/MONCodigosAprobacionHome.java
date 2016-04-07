package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCodigosAprobacionHome extends EJBHome {
    MONCodigosAprobacion create() throws RemoteException, CreateException;
}
