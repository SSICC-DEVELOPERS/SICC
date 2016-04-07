package es.indra.sicc.logicanegocio.rec;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRECMotivoDevolucionReclamoHome extends EJBHome {
    MONRECMotivoDevolucionReclamo create() throws RemoteException, 
                                                  CreateException;
}
