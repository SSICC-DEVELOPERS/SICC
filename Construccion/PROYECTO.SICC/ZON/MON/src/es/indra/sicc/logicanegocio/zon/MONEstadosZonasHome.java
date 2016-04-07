package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEstadosZonasHome extends EJBHome 
{
    MONEstadosZonas create() throws RemoteException, CreateException;
}