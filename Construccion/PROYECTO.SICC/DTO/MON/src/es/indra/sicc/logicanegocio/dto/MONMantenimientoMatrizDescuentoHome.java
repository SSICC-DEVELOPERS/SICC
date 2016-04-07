package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoMatrizDescuentoHome extends EJBHome  {
    MONMantenimientoMatrizDescuento create() throws RemoteException, CreateException;
}