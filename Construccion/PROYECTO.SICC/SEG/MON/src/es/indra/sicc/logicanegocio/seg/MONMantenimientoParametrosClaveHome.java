package es.indra.sicc.logicanegocio.seg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoParametrosClaveHome extends EJBHome 
{
  MONMantenimientoParametrosClave create() throws RemoteException, CreateException;
}