package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCuentasCorrientesPerfHome extends EJBHome  {
  MONCuentasCorrientesPerf create() throws RemoteException, CreateException;
}