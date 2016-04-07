package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoControlAlmacenHome extends EJBHome  {
    MONMantenimientoControlAlmacen create() throws RemoteException, CreateException;
}