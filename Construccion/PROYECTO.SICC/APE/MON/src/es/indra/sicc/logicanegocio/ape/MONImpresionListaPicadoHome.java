package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONImpresionListaPicadoHome extends EJBHome  {
  MONImpresionListaPicado create() throws RemoteException, CreateException;
}