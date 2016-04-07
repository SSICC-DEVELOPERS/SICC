package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConfiguracionClientesHome extends EJBHome  {
  MONConfiguracionClientes create() throws RemoteException, CreateException;
}