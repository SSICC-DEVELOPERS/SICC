package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMotivoNoCobroHome extends EJBHome {
    MONMotivoNoCobro create() throws RemoteException, CreateException;
}
