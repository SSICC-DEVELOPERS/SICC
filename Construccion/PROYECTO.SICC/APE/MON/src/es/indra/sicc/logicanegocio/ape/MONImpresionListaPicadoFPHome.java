package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONImpresionListaPicadoFPHome extends EJBHome  {
  MONImpresionListaPicadoFP create() throws RemoteException, CreateException;
}