package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoFactoresConversionHome extends EJBHome  {
  MONMantenimientoFactoresConversion create() throws RemoteException, CreateException;
}