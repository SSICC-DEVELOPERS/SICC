package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCrearListasInduccionPTLHome extends EJBHome  {
  MONCrearListasInduccionPTL create() throws RemoteException, CreateException;
}