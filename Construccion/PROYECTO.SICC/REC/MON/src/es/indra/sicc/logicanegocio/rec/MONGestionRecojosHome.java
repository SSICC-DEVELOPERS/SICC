package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionRecojosHome extends EJBHome  {
  MONGestionRecojos create() throws RemoteException, CreateException;
}