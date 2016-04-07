package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoTiposAbonoSubprocesoHome extends EJBHome 
{
    MONMantenimientoTiposAbonoSubproceso create() throws RemoteException, CreateException;
}