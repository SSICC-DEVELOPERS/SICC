package es.indra.sicc.logicanegocio.com;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParametrosTipoClienteCabeceraHome extends EJBHome {
    MONParametrosTipoClienteCabecera create() throws RemoteException, 
                                                     CreateException;
}
