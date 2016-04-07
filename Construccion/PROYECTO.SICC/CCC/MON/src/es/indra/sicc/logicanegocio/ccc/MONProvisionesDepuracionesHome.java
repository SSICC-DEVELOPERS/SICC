package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONProvisionesDepuracionesHome extends EJBHome  {
	MONProvisionesDepuraciones create() throws RemoteException, CreateException;
}