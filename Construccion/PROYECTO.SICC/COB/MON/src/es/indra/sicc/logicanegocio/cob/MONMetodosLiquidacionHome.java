package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMetodosLiquidacionHome extends EJBHome {
    MONMetodosLiquidacion create() throws RemoteException, CreateException;
}
