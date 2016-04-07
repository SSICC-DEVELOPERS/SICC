package es.indra.sicc.logicanegocio.intsys;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONIntAccesBuzonIvrRgHome extends EJBHome {
    MONIntAccesBuzonIvrRg create() throws RemoteException, CreateException;
}
