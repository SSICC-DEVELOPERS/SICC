package es.indra.sicc.logicanegocio.rec;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRECParametrizacionNMPClienteHome extends EJBHome {
    MONRECParametrizacionNMPCliente create() throws RemoteException, 
                                                    CreateException;
}
