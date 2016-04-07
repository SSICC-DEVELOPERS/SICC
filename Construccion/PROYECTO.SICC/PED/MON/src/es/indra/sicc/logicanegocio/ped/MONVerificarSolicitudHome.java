package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONVerificarSolicitudHome extends EJBHome  {
    MONVerificarSolicitud create() throws RemoteException, CreateException;
}