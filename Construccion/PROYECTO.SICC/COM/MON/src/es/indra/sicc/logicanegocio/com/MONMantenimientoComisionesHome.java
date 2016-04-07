package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoComisionesHome extends EJBHome 
{
  MONMantenimientoComisiones create() throws RemoteException, CreateException;
}