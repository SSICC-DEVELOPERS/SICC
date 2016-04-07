package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoMovimientoCajaHome extends EJBHome 
{
  MONTipoMovimientoCaja create() throws RemoteException, CreateException;
}