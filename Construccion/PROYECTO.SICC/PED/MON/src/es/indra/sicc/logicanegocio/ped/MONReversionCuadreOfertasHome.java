package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONReversionCuadreOfertasHome extends EJBHome  {
  MONReversionCuadreOfertas create() throws RemoteException, CreateException;
}