package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoCentrosServiciosHome extends EJBHome 
{
    MONMantenimientoCentrosServicios create() throws RemoteException, CreateException;
}