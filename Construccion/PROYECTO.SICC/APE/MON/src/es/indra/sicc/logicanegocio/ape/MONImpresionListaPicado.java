package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONImpresionListaPicado extends EJBObject  {
  
  void imprimirListaPicado(ArrayList consolidados) throws MareException, RemoteException;
  
}