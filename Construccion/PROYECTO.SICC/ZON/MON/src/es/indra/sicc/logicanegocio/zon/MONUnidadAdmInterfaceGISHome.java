package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONUnidadAdmInterfaceGISHome extends EJBHome  {
    MONUnidadAdmInterfaceGIS create() throws RemoteException, CreateException;
}