package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoEstatusClienteHome extends EJBHome 
{
  MONTipoEstatusCliente create() throws RemoteException, CreateException;
}