package es.indra.sicc.logicanegocio.ape;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONChequeoCajasHome extends EJBHome {
    MONChequeoCajas create() throws RemoteException, CreateException;
}
