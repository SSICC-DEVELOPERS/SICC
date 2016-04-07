package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoImpresorasHome extends EJBHome 
{
    MONMantenimientoImpresoras create() throws RemoteException, CreateException;
}