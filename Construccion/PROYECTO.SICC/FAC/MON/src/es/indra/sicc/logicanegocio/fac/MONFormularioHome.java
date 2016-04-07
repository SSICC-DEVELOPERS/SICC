package es.indra.sicc.logicanegocio.fac;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONFormularioHome extends EJBHome {
    MONFormulario create() throws RemoteException, CreateException;
}
