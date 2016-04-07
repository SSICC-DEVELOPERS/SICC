package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONPedidosSolicitudHome extends EJBHome 
{
  MONPedidosSolicitud create() throws RemoteException, CreateException;
}