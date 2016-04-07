package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONParticipantesDetalleHome extends EJBHome {
    MONParticipantesDetalle create() throws RemoteException, CreateException;
}