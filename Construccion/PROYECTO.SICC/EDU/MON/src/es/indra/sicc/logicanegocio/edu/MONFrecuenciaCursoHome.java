package es.indra.sicc.logicanegocio.edu;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONFrecuenciaCursoHome extends EJBHome {
    MONFrecuenciaCurso create() throws RemoteException, CreateException;
}
