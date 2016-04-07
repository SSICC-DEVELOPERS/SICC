package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONFleteHome extends EJBHome  {
	MONFlete create() throws RemoteException, CreateException;
}