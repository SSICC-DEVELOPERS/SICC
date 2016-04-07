package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCompromisosPagoHome extends EJBHome 
{
    MONCompromisosPago create() throws RemoteException, CreateException;
}