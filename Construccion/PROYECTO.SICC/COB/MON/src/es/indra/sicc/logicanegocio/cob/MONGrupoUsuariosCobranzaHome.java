package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONGrupoUsuariosCobranzaHome extends EJBHome {
    MONGrupoUsuariosCobranza create() throws RemoteException, CreateException;
}
