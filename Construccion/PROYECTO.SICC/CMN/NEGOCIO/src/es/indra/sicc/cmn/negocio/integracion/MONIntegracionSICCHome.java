package es.indra.sicc.cmn.negocio.integracion;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONIntegracionSICCHome extends EJBHome {
    MONIntegracionSICC create() throws RemoteException, CreateException;
}
