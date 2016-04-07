package es.indra.sicc.logicanegocio.mae;

import es.indra.sicc.logicanegocio.mae.MONEstatusCliente;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONEstatusClienteHome extends EJBHome {
    MONEstatusCliente create() throws RemoteException, CreateException;
}
