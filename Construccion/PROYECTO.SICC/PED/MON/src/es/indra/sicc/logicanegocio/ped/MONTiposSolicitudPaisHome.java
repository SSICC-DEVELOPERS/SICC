package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTiposSolicitudPaisHome extends EJBHome  {
	MONTiposSolicitudPais create() throws RemoteException, CreateException;
}