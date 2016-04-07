package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCuentasCorrientesHome extends EJBHome  {
	MONCuentasCorrientes create() throws RemoteException, CreateException;
}