package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONRecHome extends EJBHome  {
	MONRec create() throws RemoteException, CreateException;
}