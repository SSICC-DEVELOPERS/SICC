package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONGuiaArgumenCabecHome extends EJBHome {
    MONGuiaArgumenCabec create() throws RemoteException, CreateException;
}
