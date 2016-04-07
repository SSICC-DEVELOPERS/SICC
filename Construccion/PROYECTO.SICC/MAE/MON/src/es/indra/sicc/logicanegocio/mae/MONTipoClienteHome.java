package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoClienteHome extends EJBHome 
{
  MONTipoCliente create() throws RemoteException, CreateException;
}