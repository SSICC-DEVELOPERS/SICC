package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEnvioAgregadosBatchHome extends EJBHome 
{
    MONEnvioAgregadosBatch create() throws RemoteException, CreateException;
}