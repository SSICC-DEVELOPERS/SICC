package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoAgrupacionStockHome extends EJBHome  {
	MONMantenimientoAgrupacionStock create() throws RemoteException, CreateException;
}