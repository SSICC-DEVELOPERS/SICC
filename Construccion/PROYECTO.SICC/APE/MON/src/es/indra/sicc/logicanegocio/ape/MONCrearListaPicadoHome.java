package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCrearListaPicadoHome extends EJBHome  {
  MONCrearListaPicado create() throws RemoteException, CreateException;
}