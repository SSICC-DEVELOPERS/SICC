package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGestionMensajesHome extends EJBHome  {
  MONGestionMensajes create() throws RemoteException, CreateException;
}