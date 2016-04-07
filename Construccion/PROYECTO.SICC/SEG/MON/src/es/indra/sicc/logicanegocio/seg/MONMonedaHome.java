package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMonedaHome extends EJBHome {
    MONMoneda create() throws RemoteException, CreateException;
}
