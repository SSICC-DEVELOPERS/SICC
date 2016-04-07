package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONUtilidadesProcesosHome extends EJBHome  {
	MONUtilidadesProcesos create() throws RemoteException, CreateException;
}