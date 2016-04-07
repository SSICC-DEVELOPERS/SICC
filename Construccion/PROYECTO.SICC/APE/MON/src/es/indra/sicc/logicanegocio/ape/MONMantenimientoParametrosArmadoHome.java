package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMantenimientoParametrosArmadoHome extends EJBHome  {
  MONMantenimientoParametrosArmado create() throws RemoteException, CreateException;
}