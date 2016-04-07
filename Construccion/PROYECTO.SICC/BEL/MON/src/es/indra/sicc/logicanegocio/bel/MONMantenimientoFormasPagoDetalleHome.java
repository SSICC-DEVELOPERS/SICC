package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoFormasPagoDetalleHome extends EJBHome  {
	MONMantenimientoFormasPagoDetalle create() throws RemoteException, CreateException;
}