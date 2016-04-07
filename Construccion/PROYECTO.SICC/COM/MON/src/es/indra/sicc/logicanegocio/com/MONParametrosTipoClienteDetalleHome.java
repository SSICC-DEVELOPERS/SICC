package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONParametrosTipoClienteDetalleHome extends EJBHome 
{
    MONParametrosTipoClienteDetalle create() throws RemoteException, CreateException;
}