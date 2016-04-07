package es.indra.sicc.logicanegocio.msg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONPatronesHome extends EJBHome {
    MONPatrones create() throws RemoteException, CreateException;
}
