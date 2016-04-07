package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONValidacionCuadreOfertasHome extends EJBHome  {
  MONValidacionCuadreOfertas create() throws RemoteException, CreateException;
}