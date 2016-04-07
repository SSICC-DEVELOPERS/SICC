package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONImpresionSICCHome extends EJBHome  {
	MONImpresionSICC create() throws RemoteException, CreateException;
}