package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONModificarSolicitudHome extends EJBHome  {
  MONModificarSolicitud create() throws RemoteException, CreateException;
}