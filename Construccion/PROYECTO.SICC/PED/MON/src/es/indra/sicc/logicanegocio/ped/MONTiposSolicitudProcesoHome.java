package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTiposSolicitudProcesoHome extends EJBHome  {
    MONTiposSolicitudProceso create() throws RemoteException, CreateException;
}