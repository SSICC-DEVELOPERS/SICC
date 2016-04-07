package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import java.io.IOException;
import javax.ejb.CreateException;

public interface MONMensajesHome extends EJBHome  {
  MONMensajes create() throws RemoteException, CreateException;
}