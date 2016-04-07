package es.indra.sicc.logicanegocio.cal;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalTipoGestionClienteHome extends EJBHome {
    MONCalTipoGestionCliente create() throws RemoteException, CreateException;
}
