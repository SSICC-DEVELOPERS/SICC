package es.indra.sicc.logicanegocio.edu;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTipoCursoHome extends EJBHome {
    MONTipoCurso create() throws RemoteException, CreateException;
}
