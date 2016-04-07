package es.indra.sicc.logicanegocio.rec;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRECMotivoBloqueoReclamoHome extends EJBHome {
    MONRECMotivoBloqueoReclamo create() throws RemoteException, 
                                               CreateException;
}
