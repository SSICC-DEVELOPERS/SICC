package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONProcesoFueraPedidoHome extends EJBHome  {
  MONProcesoFueraPedido create() throws RemoteException, CreateException;
}