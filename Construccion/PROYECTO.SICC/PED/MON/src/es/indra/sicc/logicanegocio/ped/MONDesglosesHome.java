package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONDesglosesHome extends EJBHome  {
	MONDesgloses create() throws RemoteException, CreateException;
}