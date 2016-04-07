package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
public interface MONMantenimientoTiposMovimientosAlmacenHome extends EJBHome  {
	MONMantenimientoTiposMovimientosAlmacen create() throws RemoteException, CreateException;
}