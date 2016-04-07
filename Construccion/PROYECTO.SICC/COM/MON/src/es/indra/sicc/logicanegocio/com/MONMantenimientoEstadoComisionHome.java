package es.indra.sicc.logicanegocio.com;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMantenimientoEstadoComisionHome extends EJBHome {
    MONMantenimientoEstadoComision create() throws RemoteException, 
                                                   CreateException;
}
