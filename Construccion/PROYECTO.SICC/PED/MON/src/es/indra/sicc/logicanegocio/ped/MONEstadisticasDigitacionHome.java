package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEstadisticasDigitacionHome extends EJBHome  {
	MONEstadisticasDigitacion create() throws RemoteException, CreateException;
}