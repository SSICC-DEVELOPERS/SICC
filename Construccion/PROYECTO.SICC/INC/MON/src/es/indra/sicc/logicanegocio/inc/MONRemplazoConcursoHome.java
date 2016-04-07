package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRemplazoConcursoHome extends EJBHome {
    MONRemplazoConcurso create() throws RemoteException, CreateException;
}
