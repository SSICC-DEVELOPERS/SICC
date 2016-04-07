package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGenerarSolicitudModulosExternosHome extends EJBHome  {
	MONGenerarSolicitudModulosExternos create() throws RemoteException, CreateException;
}