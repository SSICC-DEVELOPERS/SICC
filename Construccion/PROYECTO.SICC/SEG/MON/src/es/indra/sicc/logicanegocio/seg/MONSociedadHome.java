package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONSociedadHome extends EJBHome {
    MONSociedad create() throws RemoteException, CreateException;
}
