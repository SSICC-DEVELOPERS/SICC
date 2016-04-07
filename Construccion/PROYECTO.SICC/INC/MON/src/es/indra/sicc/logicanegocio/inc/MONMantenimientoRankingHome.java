package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMantenimientoRankingHome
        extends EJBHome {
    MONMantenimientoRanking create() throws RemoteException, CreateException;
}
