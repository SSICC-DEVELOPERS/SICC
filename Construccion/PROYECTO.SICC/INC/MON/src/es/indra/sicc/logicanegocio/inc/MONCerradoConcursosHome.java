package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCerradoConcursosHome extends EJBHome  {
    MONCerradoConcursos create() throws RemoteException, CreateException;
}