package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONDigitacionInicialHome extends EJBHome  {
	MONDigitacionInicial create() throws RemoteException, CreateException;
}