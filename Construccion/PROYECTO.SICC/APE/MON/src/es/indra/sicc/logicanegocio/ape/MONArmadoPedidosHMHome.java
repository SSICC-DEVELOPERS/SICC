package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONArmadoPedidosHMHome extends EJBHome  {
  MONArmadoPedidosHM create() throws RemoteException, CreateException;
}