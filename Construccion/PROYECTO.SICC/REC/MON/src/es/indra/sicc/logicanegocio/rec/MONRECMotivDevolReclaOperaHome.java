package es.indra.sicc.logicanegocio.rec;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRECMotivDevolReclaOperaHome extends EJBHome {
    MONRECMotivDevolReclaOpera create() throws RemoteException, 
                                               CreateException;
}
