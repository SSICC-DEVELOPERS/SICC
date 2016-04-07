package es.indra.sicc.cmn.negocio.auditoria.test;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTestHome extends EJBHome  {
  MONTest create() throws RemoteException, CreateException;
}