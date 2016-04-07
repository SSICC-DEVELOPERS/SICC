package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONCargaMantenimientoListasHome extends EJBHome {
    MONCargaMantenimientoListas create() throws RemoteException, CreateException;
}