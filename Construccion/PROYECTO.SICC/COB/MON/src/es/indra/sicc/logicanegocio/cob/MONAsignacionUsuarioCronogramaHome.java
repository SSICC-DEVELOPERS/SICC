package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAsignacionUsuarioCronogramaHome extends EJBHome  {
  MONAsignacionUsuarioCronograma create() throws RemoteException, CreateException;
}