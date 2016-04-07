package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoTiposCajaEmbalajeHome extends EJBHome  {
  MONMantenimientoTiposCajaEmbalaje create() throws RemoteException, CreateException;
}