package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAlarmasHome extends EJBHome  {
  MONAlarmas create() throws RemoteException, CreateException;
}