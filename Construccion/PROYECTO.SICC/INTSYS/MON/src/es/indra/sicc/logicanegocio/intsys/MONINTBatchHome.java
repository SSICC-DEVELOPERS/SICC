package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTBatchHome extends EJBHome  {
    MONINTBatch create() throws RemoteException, CreateException;
}