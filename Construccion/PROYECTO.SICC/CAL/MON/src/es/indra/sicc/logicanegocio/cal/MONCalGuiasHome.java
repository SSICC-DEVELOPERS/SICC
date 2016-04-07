package es.indra.sicc.logicanegocio.cal;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCalGuiasHome extends EJBHome {
    MONCalGuias create() throws RemoteException, CreateException;
}
