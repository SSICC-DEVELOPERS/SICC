package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRevisionInconsistenciaChequeoHome extends EJBHome {
    MONRevisionInconsistenciaChequeo create() throws RemoteException, CreateException;
}