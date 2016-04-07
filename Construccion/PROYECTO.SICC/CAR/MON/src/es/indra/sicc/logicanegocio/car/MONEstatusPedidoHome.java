package es.indra.sicc.logicanegocio.car;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEstatusPedidoHome extends EJBHome {
    MONEstatusPedido create() throws RemoteException, CreateException;
}
