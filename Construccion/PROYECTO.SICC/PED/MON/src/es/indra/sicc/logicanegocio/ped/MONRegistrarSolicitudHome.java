package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRegistrarSolicitudHome extends EJBHome  {
  MONRegistrarSolicitud create() throws RemoteException, CreateException;
}