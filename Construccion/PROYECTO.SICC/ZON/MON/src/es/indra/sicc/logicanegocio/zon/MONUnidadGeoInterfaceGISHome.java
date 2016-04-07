package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONUnidadGeoInterfaceGISHome extends EJBHome  {
    MONUnidadGeoInterfaceGIS create() throws RemoteException, CreateException;
}