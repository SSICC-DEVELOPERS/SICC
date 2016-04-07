package es.indra.sicc.logicanegocio.intsys;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONSAPBPSHome extends EJBHome {
    MONSAPBPS create() throws RemoteException, CreateException;
}
