package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONAccionesDeCobranzaHome extends EJBHome {
    MONAccionesDeCobranza create() throws RemoteException, CreateException;
}
