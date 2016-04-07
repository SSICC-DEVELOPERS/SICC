package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoParametrosBelHome extends EJBHome 
{
    MONMantenimientoParametrosBel create() throws RemoteException, CreateException;
}