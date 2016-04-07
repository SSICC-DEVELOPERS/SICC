package es.indra.sicc.cmn.negocio.batch.consolabatch;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConsolaBatchHome extends EJBHome 
{
  MONConsolaBatch create() throws RemoteException, CreateException;
}