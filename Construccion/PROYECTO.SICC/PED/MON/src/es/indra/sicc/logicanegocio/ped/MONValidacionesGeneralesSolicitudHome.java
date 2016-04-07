package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONValidacionesGeneralesSolicitudHome extends EJBHome  {
    MONValidacionesGeneralesSolicitud create() throws RemoteException, CreateException;
}