package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONIndicadorCuadreHome extends EJBHome {
    MONIndicadorCuadre create() throws RemoteException, CreateException;
}
