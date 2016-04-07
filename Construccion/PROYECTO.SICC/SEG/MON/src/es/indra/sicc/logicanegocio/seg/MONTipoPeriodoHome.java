package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoPeriodoHome extends EJBHome {
    MONTipoPeriodo create() throws RemoteException, CreateException;
}
