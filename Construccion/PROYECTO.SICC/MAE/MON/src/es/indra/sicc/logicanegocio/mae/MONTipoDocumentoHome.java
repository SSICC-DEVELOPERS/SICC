package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoDocumentoHome extends EJBHome 
{
  MONTipoDocumento create() throws RemoteException, CreateException;
}