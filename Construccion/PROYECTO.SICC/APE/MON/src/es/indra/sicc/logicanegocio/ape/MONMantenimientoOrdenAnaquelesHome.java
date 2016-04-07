package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoOrdenAnaquelesHome extends EJBHome  {
  MONMantenimientoOrdenAnaqueles create() throws RemoteException, CreateException;
}