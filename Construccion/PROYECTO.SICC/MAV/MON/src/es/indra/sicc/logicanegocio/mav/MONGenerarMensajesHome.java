package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONGenerarMensajesHome extends EJBHome {
    MONGenerarMensajes create() throws RemoteException, CreateException;
}