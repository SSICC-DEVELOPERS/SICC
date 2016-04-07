package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONPeriodoCorporativoHome extends EJBHome {
    MONPeriodoCorporativo create() throws RemoteException, CreateException;
}
