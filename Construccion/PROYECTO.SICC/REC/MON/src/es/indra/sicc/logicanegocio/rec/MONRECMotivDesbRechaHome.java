package es.indra.sicc.logicanegocio.rec;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRECMotivDesbRechaHome extends EJBHome {
    MONRECMotivDesbRecha create() throws RemoteException, CreateException;
}
