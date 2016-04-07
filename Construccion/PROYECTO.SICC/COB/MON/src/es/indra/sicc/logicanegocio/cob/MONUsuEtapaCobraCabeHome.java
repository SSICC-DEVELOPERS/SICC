package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONUsuEtapaCobraCabeHome extends EJBHome {
    MONUsuEtapaCobraCabe create() throws RemoteException, CreateException;
}
