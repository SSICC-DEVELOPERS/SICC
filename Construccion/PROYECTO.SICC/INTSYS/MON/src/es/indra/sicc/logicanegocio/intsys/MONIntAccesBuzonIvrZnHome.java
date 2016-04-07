package es.indra.sicc.logicanegocio.intsys;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONIntAccesBuzonIvrZnHome extends EJBHome {
    MONIntAccesBuzonIvrZn create() throws RemoteException, CreateException;
}
