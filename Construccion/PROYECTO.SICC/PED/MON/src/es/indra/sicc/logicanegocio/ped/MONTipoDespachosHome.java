package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoDespachosHome extends EJBHome {
    MONTipoDespachos create() throws RemoteException, CreateException;
}
