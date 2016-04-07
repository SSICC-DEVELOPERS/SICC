package es.indra.sicc.logicanegocio.cal;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalMotivContaTipoClienteHome extends EJBHome {
    MONCalMotivContaTipoCliente create() throws RemoteException, 
                                                CreateException;
}
