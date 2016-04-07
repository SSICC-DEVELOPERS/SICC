package es.indra.sicc.logicanegocio.mae;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoAsignacionCodigoHome extends EJBHome {
    MONTipoAsignacionCodigo create() throws RemoteException, CreateException;
}
