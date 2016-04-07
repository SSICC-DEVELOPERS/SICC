package es.indra.sicc.logicanegocio.zon;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONUnidadesAdministrativasHome extends EJBHome  {
	MONUnidadesAdministrativas create() throws RemoteException, CreateException;
}