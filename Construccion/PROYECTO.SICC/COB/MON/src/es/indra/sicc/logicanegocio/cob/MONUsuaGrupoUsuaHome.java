package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONUsuaGrupoUsuaHome extends EJBHome {
    MONUsuaGrupoUsua create() throws RemoteException, CreateException;
}
