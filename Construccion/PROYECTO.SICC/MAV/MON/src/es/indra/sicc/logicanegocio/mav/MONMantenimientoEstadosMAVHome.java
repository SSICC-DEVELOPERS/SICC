package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONMantenimientoEstadosMAVHome extends EJBHome {
    MONMantenimientoEstadosMAV create() throws RemoteException, CreateException;
}