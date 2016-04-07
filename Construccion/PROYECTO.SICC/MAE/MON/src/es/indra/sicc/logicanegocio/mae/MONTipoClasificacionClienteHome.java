package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoClasificacionClienteHome extends EJBHome 
{
  MONTipoClasificacionCliente create() throws RemoteException, CreateException;
}