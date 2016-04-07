package es.indra.sicc.cmn.negocio.batch;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONBatchEJBHome extends EJBHome 
{
    MONBatchEJB create() throws RemoteException, CreateException;
}