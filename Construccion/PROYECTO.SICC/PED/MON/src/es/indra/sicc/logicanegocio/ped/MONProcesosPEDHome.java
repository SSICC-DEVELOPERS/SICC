package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONProcesosPEDHome extends EJBHome  {
  MONProcesosPED create() throws RemoteException, CreateException;
}