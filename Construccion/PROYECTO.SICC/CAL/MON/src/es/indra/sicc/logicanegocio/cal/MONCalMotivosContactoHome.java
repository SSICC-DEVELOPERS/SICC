package es.indra.sicc.logicanegocio.cal;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalMotivosContactoHome extends EJBHome {
    MONCalMotivosContacto create() throws RemoteException, CreateException;
}
