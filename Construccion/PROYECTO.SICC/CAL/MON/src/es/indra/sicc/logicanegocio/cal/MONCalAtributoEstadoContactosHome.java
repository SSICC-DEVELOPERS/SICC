package es.indra.sicc.logicanegocio.cal;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalAtributoEstadoContactosHome extends EJBHome {
    MONCalAtributoEstadoContactos create() throws RemoteException, 
                                                  CreateException;
}
