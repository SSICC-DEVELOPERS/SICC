package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONGenerarPagoIntercompaniasHome extends EJBHome {
    MONGenerarPagoIntercompanias create() throws RemoteException, CreateException;
}