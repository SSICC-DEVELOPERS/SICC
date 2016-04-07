package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoParametrosDBPHome extends EJBHome  {
    MONMantenimientoParametrosDBP create() throws RemoteException, CreateException;
}