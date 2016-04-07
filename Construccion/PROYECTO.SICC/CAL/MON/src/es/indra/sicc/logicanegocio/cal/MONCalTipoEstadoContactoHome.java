package es.indra.sicc.logicanegocio.cal;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalTipoEstadoContactoHome extends EJBHome {
    MONCalTipoEstadoContacto create() throws RemoteException, CreateException;
}
