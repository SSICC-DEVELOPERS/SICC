package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEscalaLiquidacionHome extends EJBHome {
    MONEscalaLiquidacion create() throws RemoteException, CreateException;
}
