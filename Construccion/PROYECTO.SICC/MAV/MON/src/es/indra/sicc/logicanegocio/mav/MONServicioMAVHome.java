package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONServicioMAVHome extends EJBHome {
    MONServicioMAV create() throws RemoteException, CreateException;
}