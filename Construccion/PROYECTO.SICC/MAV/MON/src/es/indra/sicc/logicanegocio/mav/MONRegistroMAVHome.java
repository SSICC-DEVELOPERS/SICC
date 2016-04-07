package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONRegistroMAVHome extends EJBHome {
    MONRegistroMAV create() throws RemoteException, CreateException;
}