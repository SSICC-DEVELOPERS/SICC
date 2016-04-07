package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTiposImpuestosUbigeoHome extends EJBHome  {
  MONTiposImpuestosUbigeo create() throws RemoteException, CreateException;
}