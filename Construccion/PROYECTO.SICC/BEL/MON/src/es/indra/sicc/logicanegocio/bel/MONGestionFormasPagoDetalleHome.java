package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionFormasPagoDetalleHome extends EJBHome  {
  MONGestionFormasPagoDetalle create() throws RemoteException, CreateException;
}